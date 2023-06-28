package com.example.poc.core.data.api_keys

import com.rockspoon.merchant.core.data.api_keys.ApiKeysSetupAppDataSource
import com.rockspoon.merchant.core.data.api_keys.ApiKeysSharedPreferencesDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A repository for the RockSpoon web services API key.
 */
// TODO to be used when the authentication flow is rewritten
class ApiKeysRepository(
	private val apiKeysSetupAppDataSource: ApiKeysSetupAppDataSource,
	private val apiKeysDataStoreDataSource: ApiKeysDataStoreDataSource,
	private val apiKeysSharedPreferencesDataSource: ApiKeysSharedPreferencesDataSource,
	private val externalScope: CoroutineScope
) {

	init {
		externalScope.launch {
			tryMigration()
		}
	}

	/**
	 * Allows to observe a state flow with teh credentials. It's a suspend function because
	 * the state flow will only be ready when the first value to be emitted is ready.
	 */
	suspend fun observeApiKey(): StateFlow<ApiKeys?> =
		apiKeysDataStoreDataSource.apiKeys.stateIn(externalScope)

	/**
	 * Retrieve a RockSpoon API key. If refresh equals to false, get from cache if exists, if not
	 * gets from data store. If true, gets a new one from Setup App and update both
	 * data sources.
	 *
	 * Note: I have no idea why all this, but the original implementation had a double cache.
	 */
	suspend fun getApiKey(refresh: Boolean = false): ApiKeys? {
		return if (refresh) withContext(externalScope.coroutineContext) {
			apiKeysSetupAppDataSource.getApiKeys()?.also { result ->
				// Sets the api key in the data store.
				apiKeysDataStoreDataSource.setApiKeys(result)
			}
			null
		} else {
			observeApiKey().value
		}
	}

	/**
	 * Update a RockSpoon API key on Setup App.
	 */
	suspend fun updateApiKey(value: ApiKeys) = withContext(externalScope.coroutineContext) {
		apiKeysSetupAppDataSource.setApiKeys(value)
		apiKeysDataStoreDataSource.setApiKeys(value)
		getApiKey(refresh = false)
	}

	/**
	 * Remove a RockSpoon API key on Setup App.
	 */
	suspend fun deleteApiKey() = withContext(externalScope.coroutineContext) {
		apiKeysSetupAppDataSource.deleteApiKeys()
		apiKeysDataStoreDataSource.deleteApiKeys()
	}

	/**
	 * Migrate from SharedPreferences to Proto DataStore.
	 */
	private suspend fun tryMigration() {
		val apiKey = apiKeysSharedPreferencesDataSource.getApiKeys() ?: return
		updateApiKey(apiKey)
		apiKeysSharedPreferencesDataSource.deleteApiKeys()

		// TODO Log the devices that already migrated so we remove this code or just schedule the
		//  removal in 6 months?
	}
}