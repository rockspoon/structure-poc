package com.example.poc.core.data.credentials

import com.example.poc.datasource.streaming_realm.RealmDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CredentialsRealmDataSourceImpl(
    private val ioDispatcher: CoroutineDispatcher
) : CredentialsRealmDataSource {

    override suspend fun setCredentials(credentials: Credentials?) {
        withContext(ioDispatcher){
            RealmDatabase.login(credentials?.accessToken)
        }
    }
}