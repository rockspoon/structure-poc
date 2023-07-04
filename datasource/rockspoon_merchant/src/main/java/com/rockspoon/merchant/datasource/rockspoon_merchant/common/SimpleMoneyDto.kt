package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import kotlinx.serialization.Serializable

@Serializable
data class SimpleMoneyDto(
	val currency: CurrencyDto,
	val amount: Long
)