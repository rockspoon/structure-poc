package com.example.poc.server.data


data class DataChangeMessage(

    var id: Long? = null,

    /**
     * This is used together with the ID to create topics on our the pub sub pattern.
     */
    var type: Type = Type.ORDER

) {

    enum class Type {
        ORDER
    }
}