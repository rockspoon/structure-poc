package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemCategory
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@SuppressWarnings("LongParameterList")
@Serializable
data class KitchenCardItemSummaryDto(
	val cardId: String,
	val cardItemId: String,
	val createdAt: Long,
	val description: String?,
	val lastUpdatedAt: Long,
	val name: String,
	val orderItemId: String,
	val seatNumbers: List<String>?,
	val status: KitchenCardItemStatusDto,
	val tableNumbers: String,
	val tableType: String?,
	val category: ItemCategory?,
	@SerialName("statuses")
	val routingStatuses: List<KitchenCardItemRoutingStatusDto>?,
	val quantity: Int,
	val measure: String?,
	val orderId: String,
	val orderShortId: String?,
	val isAvailable: Boolean?,
	val unavailabilityReason: String?,
	val bundleAttributes: KitchenCardItemBundleAttributesDto?,
	@SerialName("itemId")
	//TODO #AVAILABLE_ITEM_FEATURE ask backend to add this field in response
	val catalogItemId: String?,
	val isEdited: Boolean?
)