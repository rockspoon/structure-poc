package com.example.poc.client.data

// TODO the implementation will need to trigger an application BroadcastReceiver
interface MessageDataSource {

    /**
     * Send a message to the subscribers.
     */
    suspend fun sendMessage(message: Message)
}