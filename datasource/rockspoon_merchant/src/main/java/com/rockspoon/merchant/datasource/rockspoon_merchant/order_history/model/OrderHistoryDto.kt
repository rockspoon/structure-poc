package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model

import kotlinx.serialization.Serializable

@Serializable
data class OrderHistoryDto(
	val orderId: String,
	val venueId: String,
	val history: List<OrderHistoryItemDto>,
)