package com.example.poc.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

/**
 * Receiver for sync push messages from local network server.
 */
// Should this be a datasource? I can make the receiver set a value in a DataStore and listen to
// this datastore.
// I can make the receiver put the message in the database table and listen to this table changes
// I can trigger the sync service directly.
// Use coroutine Channels, maybe?
class LocalSeverSyncReceiver : BroadcastReceiver() {

    // TODO Trigger an sync request from the local network application sever
    //      Need to implement an Local Sever API client first
    override fun onReceive(context: Context, intent: Intent) {

        val message = intent.extras?.toModel()

        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            append("Data: $message")
            toString().also { log ->
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun Bundle.toModel() = SyncMessage(
        entityType = SyncMessage.EntityType.valueOf(getString("entityType").orEmpty()),
        entityId = getLong("entityId")
    )
}
