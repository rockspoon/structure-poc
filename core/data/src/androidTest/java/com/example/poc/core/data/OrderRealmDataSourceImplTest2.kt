package com.example.poc.core.data

import androidx.annotation.RawRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.poc.core.data.credentials.CredentialsRemoteDataSource
import com.example.poc.core.data.credentials.CredentialsRemoteDataSourceImpl
import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRealmDataSource
import com.example.poc.datasource.streaming_realm.RealmDatabase
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.syncSession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mongodb.kbson.BsonObjectId
import retrofit2.Retrofit
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class OrderRealmDataSourceImplTest2 {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun realmPreLogin() = runTest {
        // Init realm with login
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials.email, testCredentials.password)!!
        RealmDatabase.login(credentials.accessToken)

        // insert an order
        val datasource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = datasource.saveOrder(
            Order(
                name = "Order test Android"
            )
        )

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = datasource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)

        // TODO check if order is on the remote server
        RealmDatabase.instance.syncSession.uploadAllLocalChanges()
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun getCredentialsDataSource(): CredentialsRemoteDataSource {
        val client = OkHttpClient.Builder()
            .cache(null) // Make sure we do not cache any HTTP request
            .build()
        val retrofit = Retrofit.Builder()
            .callFactory { request ->
                val newRequest = request
                    .newBuilder()
                    .tag(UUID.randomUUID().toString())
                    .build()
                client.newCall(newRequest)
            }
            .baseUrl("https://api.stg.rockspoon.io/")
            .apply {
                val json = Json {
                    ignoreUnknownKeys = true
                }
                addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            }
            .build()
        val authenticationApi = retrofit.create(AuthenticationApi::class.java)

        return CredentialsRemoteDataSourceImpl(
            authenticationApi = authenticationApi,
            ioDispatcher = Dispatchers.IO
        )
    }

    private fun getPasswordCredentials() = readRawJson<PasswordCredentials>(
        com.example.poc.core.data.test.R.raw.credentials
    )

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

    internal class OrderRealmDataSourceImpl(
        private val database: Realm
    ) : OrderRealmDataSource {

        override suspend fun getOrder(id: String): Order {
            return database.query(OrderEntity::class, "_id == $0", BsonObjectId(id)).first().find()
                ?.toModel()
                ?: throw OrderRealmDataSource.OrderNotFoundException(id)
        }

        override fun observeOrder(id: String): Flow<Order> {
            return database.query(OrderEntity::class, "_id == $0", BsonObjectId(id)).first()
                .asFlow().map {
                    it.obj?.toModel() ?: throw OrderRealmDataSource.OrderNotFoundException(id)
                }
        }

        override suspend fun saveOrder(
            model: Order
        ): Order {
            val entity = model.toEntity()
            val result = database.writeBlocking {
                copyToRealm(entity)
            }
            return result.toModel()
        }

        private fun OrderEntity.toModel() = Order(
            id = id?.toHexString(),
            name = name ?: ""
        )

        private fun Order.toEntity() = OrderEntity().apply {
            this.id = this@toEntity.id?.let { BsonObjectId(it) } ?: BsonObjectId()
            this.name = this@toEntity.name
        }
    }
}