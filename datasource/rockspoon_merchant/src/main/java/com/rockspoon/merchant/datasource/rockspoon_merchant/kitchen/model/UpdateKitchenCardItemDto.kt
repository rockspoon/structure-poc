package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardItemDto(
	val name: String,
	val description: String,
	val groups: List<String>,
	val meta: UpdateKitchenCardMetaDto
)
