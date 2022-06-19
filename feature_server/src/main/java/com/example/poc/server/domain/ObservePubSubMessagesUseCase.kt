package com.example.poc.server.domain

import com.example.poc.server.data.DataChangeMessage
import kotlinx.coroutines.flow.Flow

/**
 * Observes the pub sub proto file
 */
class ObservePubSubMessagesUseCase {

    operator fun invoke() : Flow<DataChangeMessage> {
        TODO()
    }
}