package com.example.poc.client.data


data class Subscription(

    var id: Long? = null,

    var entityId: Long = 0,

    /**
     * This is used together with the ID to create topics on our the pub sub pattern.
     */
    var entityType: Type = Type.ORDER,

    /**
     * An http url to notify the user about the status change
     */
    var webHook: String? = null

) {
    enum class Type {
        ORDER
    }
}