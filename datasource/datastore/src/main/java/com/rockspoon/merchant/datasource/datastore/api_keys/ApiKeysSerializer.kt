package com.rockspoon.merchant.datasource.datastore.api_keys

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object ApiKeysSerializer : Serializer<ApiKeysProto> {

	override val defaultValue: ApiKeysProto = ApiKeysProto.getDefaultInstance()

	override suspend fun readFrom(input: InputStream): ApiKeysProto {
		try {
			return ApiKeysProto.parseFrom(input)
		} catch (exception: InvalidProtocolBufferException) {
			throw CorruptionException("Cannot read proto.", exception)
		}
	}

	override suspend fun writeTo(
		t: ApiKeysProto,
		output: OutputStream
	) = t.writeTo(output)

	val Context.apiKeysDataStore: DataStore<ApiKeysProto> by dataStore(
		fileName = "api_keys.pb",
		serializer = ApiKeysSerializer
	)
}

