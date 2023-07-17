package com.example.poc.core.data.credentials

interface CredentialsRealmDataSource {

    /**
     * Set the Credentials object in the DataStore.
     */
    suspend fun setCredentials(credentials: Credentials?, onAccessTokenExpired: () -> Unit)

    /**
     * logout current logged in user
     */
    suspend fun logout()
}