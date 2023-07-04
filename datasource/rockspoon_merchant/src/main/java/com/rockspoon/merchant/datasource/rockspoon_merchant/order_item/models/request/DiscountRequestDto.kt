package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.Serializable

@Serializable
data class DiscountRequestDto(
    val reason: String,
    val checkId: String?
)
