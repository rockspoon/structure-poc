package com.example.poc.client.data

// TODO learn how to create and notify broadcast receivers
interface MessageRepository {

    suspend fun insertMessage(message: Message)

}