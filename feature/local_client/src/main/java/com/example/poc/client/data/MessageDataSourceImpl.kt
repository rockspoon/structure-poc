package com.example.poc.client.data

import android.content.Intent
import androidx.core.os.bundleOf
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.poc.data.ACTION_LOCAL_SERVER_DATA_CHANGED

class MessageDataSourceImpl(
    private val localBroadcastManager: LocalBroadcastManager
) : MessageDataSource {

    /**
     * Send a message to the application subscribers using a LocalBroadcastManager.
     */
    override suspend fun sendMessage(message: Message) {

        Intent().apply {
            action = ACTION_LOCAL_SERVER_DATA_CHANGED
            putExtra("data", message.toBundle())
        }.also {
            localBroadcastManager.sendBroadcast(it)
        }

    }

    private fun Message.toBundle() = bundleOf(
        "entityType" to this.entityType,
        "entityId" to this.entityId
    )
}