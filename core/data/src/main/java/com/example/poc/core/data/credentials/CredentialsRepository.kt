package com.example.poc.core.data.credentials

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A repository for the application credentials information.
 *
 * Redundantly adds to credentialsSharedPreferencesDataSource as to keep legacy modules functioning.
 */
class CredentialsRepository(
    private val credentialsRemoteDataSource: CredentialsRemoteDataSource,
    private val credentialsLocalDataSource: CredentialsLocalDataSource,
    private val credentialsRealmDataSource: CredentialsRealmDataSource,
    private val externalScope: CoroutineScope
) {

    init {
        externalScope.launch {
            // Initialize Realm with credentials if it has it
            credentialsRealmDataSource.setCredentials(
                credentials = getCredentials(),
                onAccessTokenExpired = {
                    externalScope.launch {
                        getCredentials(forceRefresh = true)
                    }
                }
            )
        }
    }

    /**
     * Allows to observe a state flow with teh credentials. It's a suspend function because
     * the state flow will only be ready when the first value to be emitted is ready.
     */
    suspend fun observeCredentials(): StateFlow<Credentials?> =
        credentialsLocalDataSource.credentials.stateIn(externalScope)

    /**
     * Retrieve a object with a credentials info. If forceRefresh equals to false, get from cache if
     * exists, if not gets from DataStore. If true, gets a new one from Setup App and update both
     * data sources.
     */
    suspend fun getCredentials(
        forceRefresh: Boolean = false,
        email: String? = null,
        password: String? = null
    ): Credentials? {
        return if (forceRefresh) {
            if (email != null && password != null) {
                // If provided email and password, use them
                updateCredentialsWithPassword(email, password)
            } else {
                // If email and password were not provided, use the refresh token
                val refreshToken = observeCredentials().value?.refreshToken
                    ?: return null
                updateCredentialsWithRefreshToken(refreshToken)
            }.also {
                // Log in Realm
                credentialsRealmDataSource.setCredentials(it) {
                    externalScope.launch {
                        getCredentials(forceRefresh = true)
                    }
                }
            }
        } else {
            // Try to get on data store to keep single source of truth
            observeCredentials().value
        }
    }

    private suspend fun updateCredentialsWithPassword(
        email: String,
        password: String
    ): Credentials? {
        return credentialsRemoteDataSource.getCredentials(
            email = email,
            password = password
        )?.let { remoteCredentials ->
            updateCredentials(remoteCredentials)
        }
    }

    private suspend fun updateCredentialsWithRefreshToken(
        refreshToken: String
    ): Credentials? {
        return credentialsRemoteDataSource.updateCredentials(
            refreshToken = refreshToken
        ).let { remoteCredentials ->
            updateCredentials(remoteCredentials)
        }
    }

    /**
     * Update a RockSpoon Credentials on DataStore.
     */
    suspend fun updateCredentials(credentials: Credentials): Credentials? =
        withContext(externalScope.coroutineContext) {
            // Add credentials to DataStore
            credentialsLocalDataSource.setCredentials(credentials)

            observeCredentials().value
        }

    /**
     * Remove a RockSpoon Credentials on DataStore.
     */
    suspend fun deleteCredentials() = withContext(externalScope.coroutineContext) {
        credentialsLocalDataSource.deleteCredentials()
    }
}