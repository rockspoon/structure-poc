package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardItemStatusRequestDto(
	val cardId: String?,
	val groups: List<String>?,
	val status: KitchenCardItemStatusDto,
	val cardItemIds: List<String>,
	val lastModified: Long?,
)
