package com.example.poc.core.data.credentials

import kotlinx.coroutines.flow.Flow

interface CredentialsLocalDataSource {

    /**
     * A flow of the Credentials object stored in the DataStore.
     */
    val credentials: Flow<Credentials?>

    /**
     * Set the Credentials object in the DataStore.
     */
    suspend fun setCredentials(credentials: Credentials)

    /**
     * Clear the Credentials object in the DataStore.
     */
    suspend fun deleteCredentials()
}