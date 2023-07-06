package com.example.poc.datasource.streaming_realm

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import com.example.poc.datasource.streaming_realm.order.Item
import com.example.poc.datasource.streaming_realm.product.ProductEntity
import com.example.poc.datasource.streaming_realm.user.UserEntity
import io.realm.kotlin.MutableRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.TypedRealm
import io.realm.kotlin.ext.query
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.exceptions.ClientResetRequiredException
import io.realm.kotlin.mongodb.exceptions.UnrecoverableSyncException
import io.realm.kotlin.mongodb.sync.RecoverOrDiscardUnsyncedChangesStrategy
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import io.realm.kotlin.mongodb.sync.SyncSession
import timber.log.Timber

/**
 * Singleton to initialize the Realm object.
 */
object RealmDatabase {

    @Volatile
    lateinit var instance: Realm

    private val realmApp = App.create("realmpoc-qvjdf")

    private val schema = setOf(
        OrderEntity::class,
        OrderEntity.Item::class,
        OrderEntity.EmbeddedItem::class,
        ProductEntity::class,
        UserEntity::class,
    )

    suspend fun init() {
        init(Credentials.anonymous())
    }

    suspend fun rockspoonApiKey(key: String) {
        init(Credentials.customFunction(mapOf("rockspoon_api_key" to key)))
    }

    suspend fun accessToken(
        accessToken: String? = null,
        onTokenExpired: (() -> Unit)? = null
    ) {
        init(
            realmCredentials = accessToken?.let { Credentials.jwt(it) } ?: Credentials.anonymous(),
            onAccessTokenExpired = onTokenExpired
        )
    }

    suspend fun init(
        realmCredentials: Credentials,
        onAccessTokenExpired: (() -> Unit)? = null
    ): Realm {
        val realmUser = realmApp.login(realmCredentials)
        Timber.tag("RealmDatabase").d("Realm User: %s", realmUser.id)
        val realmConfiguration = SyncConfiguration.Builder(
            user = realmUser,
            schema = schema
        )
            .name("realm-poc")
            .schemaVersion(9)
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
        instance = Realm.open(realmConfiguration)
        Timber.tag("RealmDatabase").v("Successfully opened realm: %s", instance.configuration.name)
        return instance
    }
}