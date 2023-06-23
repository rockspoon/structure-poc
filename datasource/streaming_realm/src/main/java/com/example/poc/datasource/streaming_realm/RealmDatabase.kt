package com.example.poc.datasource.streaming_realm

import android.util.Log
import com.example.poc.datasource.streaming_realm.order.OrderEntity
import com.example.poc.datasource.streaming_realm.user.UserEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
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

    suspend fun init() {
        init(Credentials.anonymous())
    }

    suspend fun apiKey(key: String) {
        init(Credentials.apiKey(key))
    }

    suspend fun login(accessToken: String? = null) {
        init(accessToken?.let { Credentials.jwt(it) } ?: Credentials.anonymous())
    }

    suspend fun init(realmCredentials: Credentials): Realm {
        val realmUser = realmApp.login(realmCredentials)
        Log.d("RealmDatabase", "Realm User: ${realmUser.id}")
        val realmConfiguration = SyncConfiguration.Builder(
            user = realmUser,
            schema = schema
        )
            .name("realm-poc")
            .initialSubscriptions { realm ->
                add(realm.query<OrderEntity>(), updateExisting = true)
            }
            .build()
        instance = Realm.open(realmConfiguration)
        Log.v("RealmDatabase", "Successfully opened realm: ${instance.configuration.name}")
        return instance
    }
}