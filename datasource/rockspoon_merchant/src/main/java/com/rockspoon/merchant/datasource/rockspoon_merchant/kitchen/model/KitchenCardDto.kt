package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardDto(
	val cardId: String,
	val title: String,
	val index: Int?,
	val scheduledFor: Long,
	val fireType: FireTypeDto,
	val firedAt: Long,
	val meta: KitchenCardMetaDto,
	val cardItems: List<KitchenCardItemDto>,
	val groups: List<String>?,
	val isEdited: Boolean?,
	val lastModified: Long,
)
