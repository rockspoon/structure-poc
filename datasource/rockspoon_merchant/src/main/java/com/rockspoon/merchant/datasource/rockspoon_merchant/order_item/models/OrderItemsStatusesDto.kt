package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemsStatusesDto(
    val orderItemStatuses: List<ItemStatusDto>?,
    @SerialName("restaurantBundleItemStatuses")
    val bundleItemStatuses: List<BundleItemStatusDto>?
)

@Serializable
data class ItemStatusDto(
    val orderItemId: String,
    val status: GenericOrderItemDto.Status
)

@Serializable
data class BundleItemStatusDto(
    @SerialName("restaurantBundleItemId")
    val bundleOrderItemId: String,
    val status: GenericOrderItemDto.Status
)
