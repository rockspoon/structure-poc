package com.example.poc.core.data.api_keys

import android.content.ContentResolver
import android.content.ContentValues
import android.net.Uri
import com.example.poc.core.data.common.DataSourcesConfig
import com.rockspoon.merchant.core.data.api_keys.ApiKeysSetupAppDataSource
import timber.log.Timber

internal class ApiKeysSetupAppDataSourceImpl(
	private val contentResolver: ContentResolver,
	dataSourcesConfig: DataSourcesConfig
) : ApiKeysSetupAppDataSource {

	private val uri =
		Uri.parse("content://${dataSourcesConfig.rockspoonMerchantWebServiceUrl}.AuthInfoProvider/venue_api_key")

	override suspend fun getApiKeys(): ApiKeys? {
		return try {
			val cursor = contentResolver.query(uri, null, null, null, null)
			var value: String? = null
			if (cursor != null && cursor.moveToFirst()) {
				val columnIndex = cursor.getColumnIndex(ApiKeyContract.API_KEY)
				if (columnIndex != -1) value = cursor.getString(columnIndex)
				cursor.close()
			}
			if (value != null) ApiKeys(rockspoon = value)
			else null
		} catch (e: Exception) {
			throw handleError(e)
		}
	}

	override suspend fun setApiKeys(apiKeys: ApiKeys) {
		try {
			contentResolver.insert(
				uri,
				ContentValues().apply { put(ApiKeyContract.API_KEY, apiKeys.rockspoon) }
			)
		} catch (e: Exception) {
			throw handleError(e)
		}
	}

	override suspend fun deleteApiKeys() {
		try {
			contentResolver.delete(uri, null, null)
		} catch (e: Exception) {
			throw handleError(e)
		}
	}

	private fun handleError(throwable: Throwable): Throwable {
		return if (throwable is IllegalArgumentException) {
			val exception = ApiKeysSetupAppDataSource.ContentUriForVenueApiKeyNotFound(uri)
			Timber.e("ApiKeySetupAppDataSource error.", exception)
			exception
		} else {
			Timber.e("ApiKeySetupAppDataSource unknown error.", throwable)
			throwable
		}
	}

	object ApiKeyContract {
		const val API_KEY = "VENUE_API_KEY"
	}
}