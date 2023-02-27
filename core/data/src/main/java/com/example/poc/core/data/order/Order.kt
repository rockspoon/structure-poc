package com.example.poc.core.data.order

data class Order(
    var id: Long? = null,
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
