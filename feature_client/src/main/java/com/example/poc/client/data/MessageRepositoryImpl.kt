package com.example.poc.client.data

class MessageRepositoryImpl(
    private val messageDataSource: MessageDataSource
) : MessageRepository {

    override suspend fun insertMessage(message: Message) {
        messageDataSource.insertMessage(message)
    }
}