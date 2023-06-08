package com.rockspoon.merchant.datasource.datastore.current_user

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object CurrentUserSerializer : Serializer<CurrentUserProto> {

	override val defaultValue: CurrentUserProto = CurrentUserProto.getDefaultInstance()

	override suspend fun readFrom(input: InputStream): CurrentUserProto {
		try {
			return CurrentUserProto.parseFrom(input)
		} catch (exception: InvalidProtocolBufferException) {
			throw CorruptionException("Cannot read proto.", exception)
		}
	}

	override suspend fun writeTo(
		t: CurrentUserProto,
		output: OutputStream
	) = t.writeTo(output)

	val Context.currentUserDataStore: DataStore<CurrentUserProto> by dataStore(
		fileName = "current_user.pb",
		serializer = CurrentUserSerializer
	)
}

