package com.example.poc.datasource.streaming_realm

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import com.example.poc.datasource.streaming_realm.user.UserEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration

/**
 * Singleton to initialize the Realm object.
 */
object RealmDatabase {

    @Volatile
    lateinit var instance: Realm

    private val realmApp = App.create("realmpoc-qvjdf")

    private val schema = setOf(
        OrderEntity::class,
        UserEntity::class
    )

    suspend fun init(accessToken: String? = null): Realm {
        val realmConfiguration = if (accessToken != null) {
            val realmCredentials = Credentials.jwt(accessToken)
            val realmUser = realmApp.login(realmCredentials)
            SyncConfiguration.Builder(
                user = realmUser,
                schema = schema
            )
                .initialSubscriptions { realm ->
                    add(realm.query(OrderEntity::class))
                }
                .build()
        } else {
            RealmConfiguration.Builder(schema = schema)
                .deleteRealmIfMigrationNeeded()
                .build()
        }
        instance = Realm.open(realmConfiguration)
        return instance
    }
}