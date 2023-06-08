package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BundleItemsDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.ModifierSelectionDto
import kotlinx.serialization.Serializable

@Serializable
data class BundleItemMetaDataRequestDto(
    val menuId: String,
    val sectionId: String?,
    val sizeId: String,
    val bundleItems: List<BundleItemsDto>,
    val modifierSelections: List<ModifierSelectionDto>?,
    val customModifiersSelections: List<CustomModifiersSelectionRequestDto>?
)
