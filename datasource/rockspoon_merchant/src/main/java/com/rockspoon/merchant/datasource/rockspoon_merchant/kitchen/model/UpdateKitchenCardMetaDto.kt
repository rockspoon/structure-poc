package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.example.poc.core.common.serialization.BigDecimalSerializer
import java.math.BigDecimal
import kotlinx.serialization.Serializable

@Serializable
data class UpdateKitchenCardMetaDto(
	val itemId: String,
	@Serializable(with = BigDecimalSerializer::class)
	val quantity: BigDecimal,
	val measure: String
)