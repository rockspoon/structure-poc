package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.Serializable

@Serializable
data class OrderMetaDataDto(
    val orderId: String,
    val orderShortId: String?
)
