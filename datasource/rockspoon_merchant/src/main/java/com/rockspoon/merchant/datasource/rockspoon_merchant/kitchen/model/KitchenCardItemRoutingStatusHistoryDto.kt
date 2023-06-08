package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardItemRoutingStatusHistoryDto(
	val routing: String,
	val statusEntries: List<KitchenCardItemRoutingStatusHistoryEntryDto>
)