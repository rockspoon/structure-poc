package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDto(
	val type: String,
	val symbol: String,
	val decimal: Int
)