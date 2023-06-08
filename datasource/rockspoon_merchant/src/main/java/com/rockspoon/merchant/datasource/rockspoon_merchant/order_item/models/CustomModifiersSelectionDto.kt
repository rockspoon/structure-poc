package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.CustomModifiersTypeDto
import kotlinx.serialization.Serializable

@Serializable
data class CustomModifiersSelectionDto(
	val type: CustomModifiersTypeDto?,
	val description: String,
	val price: PriceDto?
)
