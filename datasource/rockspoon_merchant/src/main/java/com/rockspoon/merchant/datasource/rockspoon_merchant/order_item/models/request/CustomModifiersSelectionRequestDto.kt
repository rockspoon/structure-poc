package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.Serializable

@Serializable
data class CustomModifiersSelectionRequestDto(
	val type: CustomModifiersTypeDto?,
	val description: String,
	val price: Long
)
