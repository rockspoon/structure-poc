package com.example.poc.client.data

interface MessageDataSource {

    /**
     * Send a message to the subscribers.
     */
    suspend fun sendMessage(message: Message)
}