package com.example.poc.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Receiver for sync push messages from remote server.
 */
// I am not sure if can be like this one. It's possible that the messaging service, like FCM,
// has its own implementation restrictions.

// Initially I put receivers and providers in a separate module. Now I am putting in :app
// Since they are very platform specific, it's probably a good thing, it reduces the number
// of core modules and keep all Android specific stuff in the :app module, which may be very
// practical for multiplatform projects.
class RemoteSeverSyncReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            append("Data: ${intent.extras?.get("entityType")};${intent.extras?.get("entityId")}")
            toString().also { log ->
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }
}
