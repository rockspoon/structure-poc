package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class OrderHistoryItemDto(
	val type: OrderHistoryEntryTypeDto?,
	val date: Instant,
	val payload: OrderHistoryPayloadDto?
)