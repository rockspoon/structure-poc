package com.example.poc.server.data


// TODO Put this in non-relational DataStore<DataChangeMessage>.
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