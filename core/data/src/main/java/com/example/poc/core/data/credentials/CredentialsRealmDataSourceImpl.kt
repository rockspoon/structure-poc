package com.example.poc.core.data.credentials

import com.example.poc.datasource.streaming_realm.RealmDatabase
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CredentialsRealmDataSourceImpl(
    private val ioDispatcher: CoroutineDispatcher
) : CredentialsRealmDataSource {

    override suspend fun setCredentials(credentials: Credentials?, onAccessTokenExpired: () -> Unit) {
        withContext(ioDispatcher){
            credentials?.accessToken?.let {
                RealmDatabase.accessToken(it, onAccessTokenExpired)
            }
        }
    }

    override suspend fun logout() {
        withContext(ioDispatcher){
            RealmDatabase.logout()
        }
    }
}