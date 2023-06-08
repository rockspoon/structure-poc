package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardItemStatusDto(
    val cardId: String,
    val cardItemId: String,
    val status: KitchenCardItemStatusDto
)