package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardItemRequestDto(
	val itemId: String,
	val status: KitchenCardItemStatusDto,
	val groups: List<String>,
)
