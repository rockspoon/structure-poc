package com.rockspoon.merchant.core.data.api_keys

import android.content.Context
import com.example.poc.core.data.api_keys.ApiKeys

internal class ApiKeysSharedPreferencesDataSourceImpl(
	applicationContext: Context
) : ApiKeysSharedPreferencesDataSource {

	private val sharedPreferences =
		applicationContext.getSharedPreferences(API_KEYS_PREF_NAME, Context.MODE_PRIVATE)

	override suspend fun getApiKeys(): ApiKeys? {
		return sharedPreferences.getString(ROCKSPOON_API_KEY_PREF_KEY, null)?.toModel()
	}

	override suspend fun setApiKeys(apiKeys: ApiKeys) {
		sharedPreferences.edit()
			.putString(ROCKSPOON_API_KEY_PREF_KEY, apiKeys.rockspoon)
			.apply()
	}

	override suspend fun deleteApiKeys() {
		sharedPreferences.edit()
			.remove(ROCKSPOON_API_KEY_PREF_KEY)
			.apply()
	}

	private fun String.toModel() = ApiKeys(
		rockspoon = this
	)

	companion object {
		private const val API_KEYS_PREF_NAME = "authPrefs"
		private const val ROCKSPOON_API_KEY_PREF_KEY = "api_key"
	}
}