package com.example.poc.core.data

import androidx.annotation.RawRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.poc.core.data.credentials.CredentialsRemoteDataSource
import com.example.poc.core.data.credentials.CredentialsRemoteDataSourceImpl
import com.example.poc.core.data.credentials.GetCredentialsRequest
import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRealmDataSourceImpl
import com.example.poc.core.data.product.Product
import com.example.poc.core.data.product.ProductRealmDataSourceImpl
import com.example.poc.datasource.streaming_realm.RealmDatabase
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import com.example.poc.datasource.streaming_realm.product.ProductEntity
import com.example.poc.datasource.streaming_realm.user.UserEntity
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import io.realm.kotlin.ext.query
import io.realm.kotlin.mongodb.User
import io.realm.kotlin.mongodb.exceptions.AppException
import io.realm.kotlin.mongodb.subscriptions
import io.realm.kotlin.mongodb.syncSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mongodb.kbson.ObjectId
import retrofit2.Retrofit
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OrderRealmDataSourceImplTest {

    @Test
    fun realmPreLogin() = runBlocking {
        // Init realm with login
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)

        // insert an order
        val datasource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = datasource.saveOrder(
            Order(
                name = "Order test Android 2"
            )
        )

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = datasource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)

        // check if order was uploaded
        val wasUploaded =
            RealmDatabase.instance.syncSession.uploadAllLocalChanges(10000.milliseconds)
        assertTrue(wasUploaded)
    }

    @Test
    fun realmLoginCustomFunction() = runBlocking {
        /**
         * add api_key text file to \src\androidTest\res\raw\ directory to launch this test
         */
        val apiKey =
            getInstrumentation().context.resources.openRawResource(com.example.poc.core.data.test.R.raw.api_key)
                .bufferedReader().use {
                    it.readText()
                }
        RealmDatabase.rockspoonApiKey(apiKey)
        assertNotNull(RealmDatabase.realmApp.currentUser)
        println(RealmDatabase.realmApp.currentUser?.id)
    }

    @Test
    fun realmPostLogin() = runBlocking {
        // Init Realm without login (login anonymous)
        RealmDatabase.init()

        // insert an order
        val datasource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = datasource.saveOrder(
            Order(
                name = "Android test post login 2"
            )
        )

        // log in
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = datasource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)

        // check if order was uploaded
        val wasUploaded =
            RealmDatabase.instance.syncSession.uploadAllLocalChanges(10000.milliseconds)
        assertTrue(wasUploaded)
    }

    @Test
    fun realmSaveOrderWithItem() = runBlocking {
        // Init Realm without login (login anonymous)
        RealmDatabase.init()

        RealmDatabase.instance.subscriptions.update {
            add(it.query<OrderEntity>(), "order_entity", updateExisting = true)
            add(it.query<ProductEntity>(), "product_entity", updateExisting = true)
            add(it.query<OrderEntity.Item>(), "item_entity", updateExisting = true)
            add(it.query<UserEntity>(), "user_entity", updateExisting = true)
        }

        // insert an product
        val productDataSource = ProductRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val product = productDataSource.saveProduct(
            Product(
                title = "Android test product title"
            )
        )

        // insert an order
        val orderDataSource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = orderDataSource.saveOrder(
            Order(
                name = "Android test order with items",
                items = listOf(
                    Order.Item(
                        productId = product.id!!,
                        quantity = 2,
                        name = "test order item"
                    ),
                    Order.Item(
                        productId = product.id!!,
                        quantity = 2,
                        name = "test order item2"
                    ),
                    Order.Item(
                        productId = product.id!!,
                        quantity = 2,
                        name = "test order item3"
                    ),
                )
            )
        )

        // log in
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = orderDataSource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)

        assertTrue(orderInDatabase.items.isNotEmpty())

        // check if order was uploaded
        val wasUploaded =
            RealmDatabase.instance.syncSession.uploadAllLocalChanges(10000.milliseconds)
        assertTrue(wasUploaded)
    }

    @Test
    fun testUserApiKey() = runBlocking {
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)
        val provider = RealmDatabase.realmApp.currentUser?.apiKeyAuth
        val apiKeys = provider?.fetchAll()
        val existingKey = apiKeys?.find { it.name == "test_api_key" }
        existingKey?.let {
            provider.delete(it.id)
        }
        val key = provider?.create("test_api_key")?.value
        println(key)
        val userId = RealmDatabase.realmApp.currentUser?.id
        assertNotNull(userId)
        RealmDatabase.realmApp.currentUser?.logOut()

        RealmDatabase.init()
        assertNotNull(RealmDatabase.realmApp.currentUser?.id)
        assertNotEquals(userId, RealmDatabase.realmApp.currentUser?.id)

        if (key != null) {
            RealmDatabase.apiKey(key)
            println("api_key  = $key")
            println("user_id  = $userId")
        }
        assertEquals(userId, RealmDatabase.realmApp.currentUser?.id)
        assertEquals(User.State.LOGGED_IN, RealmDatabase.realmApp.currentUser?.state)

    }

    @Test
    fun testApiKeyCount() = runBlocking {
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)
        val provider = RealmDatabase.realmApp.currentUser?.apiKeyAuth
        val apiKeys = provider?.fetchAll()
        apiKeys?.forEach {
            provider.delete(it.id)
        }

        val keys = (0..19).mapNotNull {
            try {
                provider?.create("key_$it")
            } catch (ex: Exception) {
                null
            }
        }
        assertEquals(20, keys.size)

        val lastKey = try {
            provider?.create("key_21")
        } catch (ex: Exception) {
            assert(ex is AppException)
            null
        }

        assertNull(lastKey)
        keys.forEach {
            provider?.delete(it.id)
        }
    }


    @OptIn(ExperimentalSerializationApi::class)
    private fun getCredentialsDataSource(): CredentialsRemoteDataSource {
        val client =
            OkHttpClient.Builder().cache(null) // Make sure we do not cache any HTTP request
                .build()
        val retrofit = Retrofit.Builder().callFactory { request ->
            val newRequest = request.newBuilder().tag(UUID.randomUUID().toString()).build()
            client.newCall(newRequest)
        }.baseUrl("https://api.stg.rockspoon.io/").apply {
            val json = Json {
                ignoreUnknownKeys = true
            }
            addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        }.build()
        val authenticationApi = retrofit.create(AuthenticationApi::class.java)

        return CredentialsRemoteDataSourceImpl(
            authenticationApi = authenticationApi,
            ioDispatcher = Dispatchers.IO
        )
    }

    @Test
    fun testRealmRequests() = runBlocking {
        // Init Realm without login (login anonymous)
        RealmDatabase.init()
        val dataSource = OrderRealmDataSourceImpl(RealmDatabase.instance)
        var collection: List<OrderEntity> = emptyList()
        val observationJob = launch {
            dataSource.observeOrders().collect {
                collection = it
            }
        }

        delay(200)

        val size = collection.size
        println("old size = $size")

        dataSource.saveOrder(
            Order(
                name = "Android test order with items", items = emptyList()
            )
        )
        delay(200)
        println("new size = ${collection.size}")
        assertEquals(size + 1, collection.size)
        observationJob.cancel()
    }

    @Test
    fun removeOrderEntities() = runBlocking {
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)
        RealmDatabase.instance.writeBlocking {
            val orders = RealmDatabase.instance.query(OrderEntity::class).find()
            delete(orders)
        }
        val dataSource = OrderRealmDataSourceImpl(RealmDatabase.instance)

        println(dataSource.getOrders().size)

    }

    @Test
    fun testRemoveRelationObject() = runBlocking {
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials)!!
        RealmDatabase.accessToken(credentials.accessToken)
        val order =
            RealmDatabase.instance.query(OrderEntity::class, "_id=$0", ObjectId("64b53551d9e60248592920a9"))
                .find().first()

        RealmDatabase.instance.write {
            val item = order.items.first()
            findLatest(item)?.apply {
                delete(this)
            }
        }
        val updatedOrder =
            RealmDatabase.instance.query(OrderEntity::class, "_id=$0", ObjectId("64b53551d9e60248592920a9"))
                .find().first()
        assertTrue(updatedOrder.items.size == order.items.size -1 )
    }

    /**
     * add credentials file to \src\androidTest\res\raw directory in json format
     * {"email":"","password":""}
     */
    private fun getPasswordCredentials() = readRawJson<PasswordCredentials>(
        com.example.poc.core.data.test.R.raw.credentials
    ).let { GetCredentialsRequest.Email(it.email, it.password) }

    private inline fun <reified T> readRawJson(@RawRes rawResId: Int): T {
        getInstrumentation().context.resources.openRawResource(rawResId).bufferedReader().use {
            return Json.decodeFromString(it.readText())
        }
    }

    @Serializable
    data class PasswordCredentials(
        val email: String,
        val password: String
    )
}