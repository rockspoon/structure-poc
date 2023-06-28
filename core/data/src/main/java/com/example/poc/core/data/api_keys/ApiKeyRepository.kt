package com.rockspoon.merchant.core.data.api_keys

import com.example.poc.core.data.api_keys.ApiKeys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

/**
 * A repository for the RockSpoon web services API key.
 */
// NOTE: this repository will be replaced by ApisKeyRepository when the authentication flow
// is rewritten.
class ApiKeyRepository(
	private val apiKeysSetupAppDataSource: ApiKeysSetupAppDataSource,
	private val apiKeysSharedPreferencesDataSource: ApiKeysSharedPreferencesDataSource,
	private val externalScope: CoroutineScope
) {

	private val apiKeysMutex = Mutex()

	private var apiKeys: ApiKeys? = null

	/**
	 * Retrieve a RockSpoon API key. If refresh equals to false, get from cache if exists, if not
	 * gets from SharedPreferences. If true, gets a new one from Setup App and update both
	 * data sources.
	 *
	 * Note: I have no idea why all this, but the original implementation had a double cache.
	 */
	suspend fun getApiKey(refresh: Boolean = false): ApiKeys? {
		return if (refresh) withContext(externalScope.coroutineContext) {
			apiKeysSetupAppDataSource.getApiKeys()?.also { result ->
				// Sets the api key in the shared preferences.
				apiKeysSharedPreferencesDataSource.setApiKeys(result)
				// Thread-safe write to apiKey.
				apiKeysMutex.withLock { apiKeys = result }
			}
			apiKeys
		} else apiKeysMutex.withLock { apiKeys } ?: run {
			apiKeysMutex.withLock {
				apiKeys = apiKeysSharedPreferencesDataSource.getApiKeys()
					?: apiKeysSetupAppDataSource.getApiKeys()
			}
			apiKeysMutex.withLock { apiKeys }
		}
	}

	/**
	 * Update a RockSpoon API key on Setup App.
	 */
	suspend fun setApiKeys(value: ApiKeys) = withContext(externalScope.coroutineContext) {
		apiKeysSetupAppDataSource.setApiKeys(value)
		getApiKey(refresh = true)
	}

	/**
	 * Remove a RockSpoon API key on Setup App.
	 */
	suspend fun deleteApiKey() = withContext(externalScope.coroutineContext) {
		apiKeysSetupAppDataSource.deleteApiKeys()
		apiKeysSharedPreferencesDataSource.deleteApiKeys()
	}
}