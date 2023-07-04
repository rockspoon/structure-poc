package com.rockspoon.merchant.datasource.datastore.venue

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object VenueSerializer : Serializer<VenueProto> {

    override val defaultValue: VenueProto = VenueProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): VenueProto {
        try {
            return VenueProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: VenueProto,
        output: OutputStream
    ) = t.writeTo(output)

    val Context.venueDataStore: DataStore<VenueProto> by dataStore(
        fileName = "venue.pb",
        serializer = VenueSerializer
    )
}

