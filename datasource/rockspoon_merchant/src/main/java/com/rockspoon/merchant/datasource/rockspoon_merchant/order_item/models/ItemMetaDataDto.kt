package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.Serializable

@Serializable
data class ItemMetaDataDto(
    val menuId: String?,
    val sectionId: String?,
    val sizeId: String?,
    val quantityStep: QuantityStepDetailsDto?,
    val modifierSelections: List<ModifierSelectionDto>?,
    val customModifiersSelections: List<CustomModifiersSelectionDto>?,
    val routings: List<String>?
)
