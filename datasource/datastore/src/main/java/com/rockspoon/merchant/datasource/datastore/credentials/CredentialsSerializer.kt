package com.rockspoon.merchant.datasource.datastore.credentials

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object CredentialsSerializer : Serializer<CredentialsProto> {

    override val defaultValue: CredentialsProto = CredentialsProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): CredentialsProto {
        try {
            return CredentialsProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: CredentialsProto,
        output: OutputStream
    ) = t.writeTo(output)

    val Context.credentialsDataStore: DataStore<CredentialsProto> by dataStore(
        fileName = "credentials.pb",
        serializer = CredentialsSerializer
    )
}

