package com.rockspoon.merchant.datasource.datastore.device

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object DeviceSerializer : Serializer<DeviceProto> {

    override val defaultValue: DeviceProto = DeviceProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): DeviceProto {
        try {
            return DeviceProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: DeviceProto,
        output: OutputStream
    ) = t.writeTo(output)

    val Context.deviceDataStore: DataStore<DeviceProto> by dataStore(
        fileName = "device.pb",
        serializer = DeviceSerializer
    )
}

