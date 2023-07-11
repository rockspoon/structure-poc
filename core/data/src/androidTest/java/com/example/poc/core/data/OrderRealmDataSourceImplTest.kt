package com.example.poc.core.data

import androidx.annotation.RawRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.poc.core.data.credentials.CredentialsRemoteDataSource
import com.example.poc.core.data.credentials.CredentialsRemoteDataSourceImpl
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
import io.realm.kotlin.MutableRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.TypedRealm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.User
import io.realm.kotlin.mongodb.exceptions.AppException
import io.realm.kotlin.mongodb.exceptions.ClientResetRequiredException
import io.realm.kotlin.mongodb.exceptions.UnrecoverableSyncException
import io.realm.kotlin.mongodb.subscriptions
import io.realm.kotlin.mongodb.sync.RecoverOrDiscardUnsyncedChangesStrategy
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.mongodb.sync.SyncSession
import io.realm.kotlin.mongodb.syncSession
import io.realm.kotlin.types.BaseRealmObject
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PersistedName
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import retrofit2.Retrofit
import timber.log.Timber
import java.util.UUID
import kotlin.reflect.KClass
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
        val testCredentials = getTestCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
                .getCredentials(testCredentials.email, testCredentials.password)!!
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
        val apiKey = getInstrumentation().context.resources.openRawResource(com.example.poc.core.data.test.R.raw.api_key).bufferedReader().use {
           it.readText()
        }
        RealmDatabase.rockspoonApiKey(apiKey)
        assertNotNull(RealmDatabase.realmApp.currentUser)
        println(RealmDatabase.realmApp.currentUser?.id)
    }

	@Test
	fun givenAnOrderInsertedWithoutLogin_whenUserLogIn_thenTheOrderMustBeSynced() = runBlocking {
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
		val testCredentials = getTestCredentials()
		val credentialsDataSource = getCredentialsDataSource()
		val credentials = credentialsDataSource
			.getCredentials(testCredentials.email, testCredentials.password)!!
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

	/**
	 * Given an order with nested items, when it's written with Realm with Sync configuration,
	 * then the order and the items must be saved remotely with auto generated IDs.
	 */
	@Test
	fun givenAnRealmWithSync_whenUserWritesAnOrderWithNestedItems_thenTheOrderMustBeSynced() =
		runBlocking {
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
							quantity = 2
						)
					)
				)
			)

			// log in
			val testCredentials = getTestCredentials()
			val credentialsDataSource = getCredentialsDataSource()
			val credentials = credentialsDataSource
				.getCredentials(testCredentials.email, testCredentials.password)!!
			RealmDatabase.accessToken(credentials.accessToken)

			// check if it was synced
			assertNotNull(order.id)
			val orderInDatabase = orderDataSource.getOrder(order.id!!)
			assertNotNull(orderInDatabase)

			// check if order was uploaded
			val wasUploaded =
				RealmDatabase.instance.syncSession.uploadAllLocalChanges(10000.milliseconds)
			assertTrue(wasUploaded)
		}

    @Test
    fun testUserApiKey() = runBlocking {
        val testCredentials = getTestCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials.email, testCredentials.password)!!
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
        val testCredentials = getTestCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials =
            credentialsDataSource.getCredentials(testCredentials.email, testCredentials.password)!!
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

	@PersistedName("order2")
	open class OrderEntity2 : RealmObject {

		@PrimaryKey
		@PersistedName("_id")
		var id: ObjectId? = BsonObjectId()

		var name: String? = null

		var items: RealmList<Item2> = realmListOf()

		open class Item2 : RealmObject {

			@PrimaryKey
			@PersistedName("_id")
			var id: ObjectId? = BsonObjectId()

			var productId: ObjectId = BsonObjectId()

			var number: Int = 1

		}

	}

	/**
	 * Given an outdated scheme in an database, when user writes an order,
	 * then the order must be synced with the server.
	 */
	@Test
	fun givenAnOldScheme_whenWritingAnOrder_thenTheOrderMustBeSynced() = runBlocking {
		// 1. Create a Realm with current scheme
		val realmDatabaseV3 = getRealm(
			schema = setOf(
				OrderEntity::class,
				UserEntity::class,
				OrderEntity.Item::class,
				ProductEntity::class,
				OrderEntity.EmbeddedItem::class,
			)
		)
		val productDataSource = ProductRealmDataSourceImpl(
			database = realmDatabaseV3
		)

		// insert a product
		val product = productDataSource.saveProduct(
			Product(
				title = "RedBull"
			)
		)

		// insert an order
		val orderDataSource = OrderRealmDataSourceImpl(
			database = realmDatabaseV3
		)
		val order = orderDataSource.saveOrder(
			Order(
				name = "Order V1",
				items = listOf(
					Order.Item(
						productId = product.id!!,
						quantity = 2
					)
				)
			)
		)

		// 2. Create a Realm with another scheme (the outdated scheme)
		val realmDatabaseV1 = getRealm(
			schema = setOf(
				OrderEntity2::class,
				UserEntity::class,
				OrderEntity.Item::class,
				ProductEntity::class,
				OrderEntity.EmbeddedItem::class,
			)
		)
		// Insert an order
		val orderDataSource2 = OrderRealmDataSourceImpl(
			database = realmDatabaseV1
		)
		val order2 = orderDataSource.saveOrder(
			Order(
				name = "Order V2",
				items = listOf(
					Order.Item(
						productId = product.id!!,
						quantity = 2
					)
				)
			)
		)

		// 3. Check if it was uploaded
		assertNotNull(order2.id)
		val orderInDatabase = orderDataSource.getOrder(order2.id!!)
		assertNotNull(orderInDatabase)
		val wasUploaded =
			realmDatabaseV1.syncSession.uploadAllLocalChanges(10000.milliseconds)
		assertTrue(wasUploaded)
	}

	/**
	 * Given an outdated scheme in an database, when update the scheme,
	 * then the order must be synced with the server.
	 */
	@Test
	fun givenAnOldScheme_whenUpdateTheScheme_thenTheDataMustBePreserved() {
		// 1. Create a Realm with current scheme

		// 2. Create a Realm with another scheme and implement on migration

		// 3. Check if it was uploaded
	}

	private val realmApp = App.create("realmpoc-qvjdf")

	private suspend fun getRealm(
		schema: Set<KClass<out BaseRealmObject>>,
		onAccessTokenExpired: (() -> Unit)? = null
	): Realm {

		// log in
		val testCredentials = getTestCredentials()
		val credentialsDataSource = getCredentialsDataSource()
		val credentials = credentialsDataSource
			.getCredentials(testCredentials.email, testCredentials.password)!!
		RealmDatabase.accessToken(credentials.accessToken)
		val realmUser =
			realmApp.login(io.realm.kotlin.mongodb.Credentials.jwt(credentials.accessToken))
		val realmConfiguration = SyncConfiguration.Builder(
			user = realmUser,
			schema = schema
		)
			.name("realm-poc")
			.schemaVersion(8)
			.initialSubscriptions { realm ->
				add(realm.query<OrderEntity>(), updateExisting = true)
				add(realm.query<ProductEntity>(), updateExisting = true)
			}
			.errorHandler { session, error ->
				when (error) {
					is UnrecoverableSyncException -> {}
				}
			}
			.syncClientResetStrategy(object : RecoverOrDiscardUnsyncedChangesStrategy {
				override fun onBeforeReset(realm: TypedRealm) {
					Timber.i("Client reset: attempting to automatically recover unsynced changes")
				}

				// Executed before the client reset begins.
				// Can be used to notify the user that a reset will happen.
				override fun onAfterRecovery(before: TypedRealm, after: MutableRealm) {
					Timber.i("Client reset: successfully recovered all unsynced changes")
				}

				// Executed if and only if the automatic recovery has succeeded.
				override fun onAfterDiscard(before: TypedRealm, after: MutableRealm) {
					Timber.i("Client reset: recovery unsuccessful, attempting to manually recover any changes")
					// ... Try to manually recover any unsynced data
				}

				// Executed if the automatic recovery has failed,
				// but the discard unsynced changes fallback has completed successfully.
				override fun onManualResetFallback(
					session: SyncSession,
					exception: ClientResetRequiredException
				) {
					Timber.i("Client reset: manual reset required")
					// ... Handle the reset manually here
					when (session.state) {
						SyncSession.State.WAITING_FOR_ACCESS_TOKEN -> onAccessTokenExpired?.invoke()
						else -> {}
					}
				}
				// Automatic reset failed.
			}) // Set your client reset strategy
			.build()

		return Realm.open(configuration = realmConfiguration)
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

	/**
	 * add credentials file to \src\androidTest\res\raw directory in json format
	 * {"email": "****", "password": "****", "api_key": "****"}
	 */
	private fun getTestCredentials() = readRawJson<Credentials>(
		com.example.poc.core.data.test.R.raw.credentials
	)

	private inline fun <reified T> readRawJson(@RawRes rawResId: Int): T {
		getInstrumentation().context.resources.openRawResource(rawResId).bufferedReader().use {
			return Json.decodeFromString(it.readText())
		}
	}

	@Serializable
	data class Credentials(
		val email: String,
		val password: String,
		@SerialName("api_key")
		val apiKey: String
	)
}