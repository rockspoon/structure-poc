package com.example.poc.core.data.order

data class Order(

    var id: String? = null,

    val status: Status = Status.CREATED
) {
    enum class Status {

        CREATED,

        IN_PROGRESS,

        READY,

        DELIVERED,

        CLOSED,

        PAID
    }
}
