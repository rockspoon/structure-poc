package com.example.poc.client.data

class MessageRepositoryImpl(
    private val messageDataSource: MessageDataSource
) : MessageRepository {

    override suspend fun sendMessage(message: Message) {
        messageDataSource.sendMessage(message)
    }
}