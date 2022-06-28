package com.example.poc.client.data

// TODO the implementation will need to trigger an application BroadcastReceiver
interface MessageDataSource {

    suspend fun insertMessage(message: Message)
}