package com.example.poc.datasource.serverdatastore.subscription

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object SubscriptionSerializer : Serializer<SubscriptionProto> {

    override val defaultValue: SubscriptionProto =
        SubscriptionProto.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): SubscriptionProto {
        try {
            return SubscriptionProto.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: SubscriptionProto,
        output: OutputStream
    ) = t.writeTo(output)

    val Context.subscriptionDataStore: DataStore<SubscriptionProto> by dataStore(
        fileName = "subscription.pb",
        serializer = SubscriptionSerializer
    )
}

