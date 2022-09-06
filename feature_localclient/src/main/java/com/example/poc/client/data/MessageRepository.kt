package com.example.poc.client.data

interface MessageRepository {

    /**
     * Send messages to this application subscribers.
     */
    suspend fun sendMessage(message: Message)

}