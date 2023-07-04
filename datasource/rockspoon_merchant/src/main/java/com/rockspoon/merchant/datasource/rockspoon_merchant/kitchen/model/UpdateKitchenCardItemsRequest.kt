package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardItemsRequest(
    val cardId: String,
    val cardItems: List<KitchenCardItemRequestDto>,
    val lastModified: Long,
)