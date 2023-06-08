package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemCategory
import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardItemDto(
	val cardItemId: String,
	val name: String,
	val description: String?,
	val status: KitchenCardItemStatusDto,
	val lastUpdatedAt: Long,
	val category: ItemCategory?,
	val meta: KitchenCardItemMetaDto,
	val groupStatuses: Map<String, KitchenCardItemStatusDto?>?,
	val addon: Boolean?,
	val isEdited: Boolean?
)
