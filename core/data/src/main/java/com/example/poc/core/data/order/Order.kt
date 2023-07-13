package com.example.poc.core.data.order

data class Order(

    var id: String? = null,

    val name: String = "",

    val status: Status = Status.CREATED,

    val items: List<Item> = emptyList()
) {
    enum class Status {

        CREATED,

        IN_PROGRESS,

        READY,

        DELIVERED,

        CLOSED,

        PAID
    }

    data class Item(

        val id: String? = null,

        val productId: Long,

        var quantity: Int = 1
    )
}
