package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardRequestDto(
	val title: String,
	val fireType: FireTypeDto,
	val fireAt: Long,
	val description: String,
	val cardItems: List<UpdateKitchenCardItemDto>,
	val cardType: KitchenCardTypeDto
)