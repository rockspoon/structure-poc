package com.rockspoon.merchant.core.data.api_keys

import android.net.Uri
import com.example.poc.core.data.api_keys.ApiKeys

/**
 * A data source that represents the RockSpoon Setup App content provider for API keys.
 */
interface ApiKeysSetupAppDataSource {

	/**
	 * Get the RockSpoon API key stored in the Setup App.
	 */
	suspend fun getApiKeys(): ApiKeys?

	/**
	 * Set a RockSpoon API key in the Setup App.
	 */
	suspend fun setApiKeys(apiKeys: ApiKeys)

	/**
	 * Delete a RockSpoon API key in the Setup App.
	 */
	suspend fun deleteApiKeys()

	class ContentUriForVenueApiKeyNotFound(uri: Uri) : IllegalArgumentException(
		"Content URI '$uri' was not found on the RockSpoon Setup App provider while trying to " +
				"retrieve an RockSpoon API key. Check if the version 1.1.1 or later of Setup App " +
				"version 1.1.1 is installed on the device."
	)
}