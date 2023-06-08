package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.Serializable

@Serializable
data class ModifierSelectionDto(
    val modifierId: String,
    val modifierOptionIds: List<String>? = null,
    val isAvailable: Boolean? = null
)
