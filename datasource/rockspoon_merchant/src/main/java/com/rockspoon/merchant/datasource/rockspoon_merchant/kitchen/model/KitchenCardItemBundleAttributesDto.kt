package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BundleTypeDto
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class KitchenCardItemBundleAttributesDto(
	val bundleItems: List<KitchenCardBundleItemDto>,
	val bundleType: BundleTypeDto,
	@Serializable(with = BigDecimalSerializer::class)
	val quantity: BigDecimal?
)
