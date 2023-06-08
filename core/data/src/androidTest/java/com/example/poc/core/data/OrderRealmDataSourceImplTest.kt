package com.example.poc.core.data

import androidx.annotation.RawRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.example.poc.core.data.credentials.CredentialsRemoteDataSource
import com.example.poc.core.data.credentials.CredentialsRemoteDataSourceImpl
import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRealmDataSourceImpl
import com.example.poc.datasource.streaming_realm.RealmDatabase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
import retrofit2.Retrofit
import java.util.UUID

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OrderRealmDataSourceImplTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun realmPostLogin() = runTest {
        // Init realm without login
        RealmDatabase.init()

        // insert an order
        val datasource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = datasource.saveOrder(Order())

        // log in
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials.email, testCredentials.password)!!
        RealmDatabase.init(credentials.accessToken)

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = datasource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)
        // TODO check if order is on the distant server
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun realmPreLogin() = runTest {
        // Init realm with login
        val testCredentials = getPasswordCredentials()
        val credentialsDataSource = getCredentialsDataSource()
        val credentials = credentialsDataSource
            .getCredentials(testCredentials.email, testCredentials.password)!!
        RealmDatabase.init(credentials.accessToken)

        // insert an order
        val datasource = OrderRealmDataSourceImpl(
            database = RealmDatabase.instance
        )
        val order = datasource.saveOrder(Order())

        // check if it was synced
        assertNotNull(order.id)
        val orderInDatabase = datasource.getOrder(order.id!!)
        assertNotNull(orderInDatabase)
        // TODO check if order is on the distant server
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
}