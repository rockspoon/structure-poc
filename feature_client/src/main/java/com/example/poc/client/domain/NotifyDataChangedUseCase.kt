package com.example.poc.client.domain

import com.example.poc.client.data.Message
import com.example.poc.client.data.MessageRepository

/**
 * Notifies an application broadcast receiver that a new message arrived.
 */
// TODO learn how to create and notify broadcast receivers
class NotifyDataChangedUseCase(
    private val messageRepository: MessageRepository
) {

    suspend operator fun invoke(message: Message) {
        TODO()
    }

}