package com.example.poc.core.data.api_keys

import androidx.datastore.core.DataStore
import com.example.poc.core.data.api_keys.ApiKeys
import com.example.poc.core.data.api_keys.ApiKeysDataStoreDataSource
import com.rockspoon.merchant.datasource.datastore.api_keys.ApiKeysProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class ApiKeysDataStoreDataSourceImpl(
	private val apiKeyDataStore: DataStore<ApiKeysProto>
) : ApiKeysDataStoreDataSource {

	override val apiKeys: Flow<ApiKeys?> =
		apiKeyDataStore.data.map { apiKeysProto ->
			apiKeysProto.toModel()
		}

	override suspend fun setApiKeys(apiKeys: ApiKeys) {
		apiKeyDataStore.updateData {
			apiKeys.toProto()
		}
	}

	override suspend fun deleteApiKeys() {
		apiKeyDataStore.updateData { apiKeysProto ->
			apiKeysProto.toBuilder()
				.clear()
				.build()
		}
	}


	private fun ApiKeysProto.toModel() = ApiKeys(
		rockspoon = this.rockspoon
	)

	private fun ApiKeys.toProto() = ApiKeysProto.newBuilder()
		.setRockspoon(rockspoon)
		.build()
}



