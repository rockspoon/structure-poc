package com.example.poc.core.data.order

import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.Product

data class Order(

    var id: String? = null,

    val name: String = "",

    val status: Status = Status.CREATED,

    val items: List<Item>
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

        val productId: String,

        val quantity: Int = 1
    )
}
