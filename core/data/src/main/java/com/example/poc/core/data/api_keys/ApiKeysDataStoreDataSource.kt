package com.example.poc.core.data.api_keys

import com.example.poc.core.data.api_keys.ApiKeys
import kotlinx.coroutines.flow.Flow

/**
 * Class to set and retrieve the API keys value using a
 * Proto DataStore.
 */
interface ApiKeysDataStoreDataSource {

	/**
	 * A flow of the API keys object stored in the DataStore.
	 */
	val apiKeys: Flow<ApiKeys?>

	/**
	 * Set the API keys object in the DataStore.
	 */
	suspend fun setApiKeys(apiKeys: ApiKeys)

	/**
	 * Clear the API keys object in the DataStore.
	 */
	suspend fun deleteApiKeys()
}