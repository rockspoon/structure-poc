package com.rockspoon.merchant.core.data.api_keys

import com.example.poc.core.data.api_keys.ApiKeys

/**
 * A data source that represents the SharedPreferences storage for API keys.
 */
interface ApiKeysSharedPreferencesDataSource {

	/**
	 * Get the RockSpoon API key stored in the SharedPreferences.
	 */
	suspend fun getApiKeys(): ApiKeys?

	/**
	 * Set a RockSpoon API key in the SharedPreferences.
	 */
	suspend fun setApiKeys(apiKeys: ApiKeys)

	/**
	 * Delete a RockSpoon API key in the SharedPreferences.
	 */
	suspend fun deleteApiKeys()
}