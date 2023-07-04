package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.Serializable

/**
 * UnfireOrderItemRequest represents the list of items to be unfired.
 *
 * @param itemsToUnfire
 * @param restaurantBundleItemsToUnfire
 */
@Serializable
data class UnfireOrderItemRequestDto(
    val itemsToUnfire: List<String>? = null,
    val restaurantBundleItemsToUnfire: List<String>? = null
)

