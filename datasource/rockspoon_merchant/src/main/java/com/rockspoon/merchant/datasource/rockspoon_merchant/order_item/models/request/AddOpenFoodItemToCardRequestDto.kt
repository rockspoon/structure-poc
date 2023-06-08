package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.Serializable

@Serializable
data class AddOpenFoodItemToCardRequestDto(
    val items: List<OpenFoodItemAddRequestDto>
)
