package com.example.poc.core.data.order

import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.Product
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class Order(

    var id: String? = null,

    val name: String = "",

    val status: Status = Status.CREATED,

    val items: RealmList<Item> = realmListOf()
) {
    enum class Status {

        CREATED,

        IN_PROGRESS,

        READY,

        DELIVERED,

        CLOSED,

        PAID
    }

    class Item(

        val id: String? = null,

        val productId: Long,

        val quantity: Int = 1
    ): RealmObject
}
