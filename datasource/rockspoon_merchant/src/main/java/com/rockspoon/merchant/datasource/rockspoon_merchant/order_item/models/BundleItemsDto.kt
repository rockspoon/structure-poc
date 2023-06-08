package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.CustomModifiersSelectionRequestDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BundleItemsDto(
	@SerialName("bundleItemId")
	val bundleCatalogItemId: String,
	val bundleSectionId: String?,
	@SerialName("restaurantBundleItemId")
	val bundleOrderItemId: String?,
	val modifierSelections: List<ModifierSelectionDto>?,
	val customModifiersSelections: List<CustomModifiersSelectionRequestDto>?,
	val course: Int,
	val quantity: Int
)
