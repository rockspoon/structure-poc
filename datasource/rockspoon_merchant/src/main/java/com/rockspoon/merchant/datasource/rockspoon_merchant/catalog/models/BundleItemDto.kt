package com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.CustomModifiersSelectionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.GenericOrderItemDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.ModifierSelectionDto
import kotlinx.serialization.Serializable

@Serializable
data class BundleItemDto(
    val course: Int,
    val restaurantBundleItemId: String,
    val bundleItemId: String,
    val itemId: String?,
    val bundleSectionId: String?,
    val name: String,
    val description: String,
    val status: GenericOrderItemDto.Status?,
    val modifierSelections: List<ModifierSelectionDto>?,
    val customModifierSelections: List<CustomModifiersSelectionDto>?,
    val quantity: Int? = null,
    val isAvailable: Boolean,
    val isComp: Boolean? = null,
    val unavailabilityReason: String? = null
)

