package com.example.poc.client.data


/**
 * A message that comes in the push handler.
 */
data class Message(

    var entityId: Long = 0,

    /**
     * This is used together with the ID to create topics on our the pub sub pattern.
     */
    var entityType: Type = Type.ORDER
) {
    enum class Type {
        ORDER
    }
}