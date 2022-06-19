package com.example.poc.server.data

data class Order(

    var id: Long? = null,

    var status: Status

) {
    enum class Status {

        OPEN,

        PREPARING,

        READY,

        IN_TRANSIT,

        DELIVERED
    }
}