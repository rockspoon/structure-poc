package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FireOrderItemsRequestDto(
    val delayInMinute: Long,
    val orderItemIds: List<String>?,
    @SerialName("restaurantBundleItemIds")
    val bundleOrderItemIds: List<String>?,
    val type: String
)
