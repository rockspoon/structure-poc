package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

/**
 * if price is 1$
 * price = 1.00
 * value = 100
 */
@Deprecated("use SimpleMoneyDTO")
// TODO #TECH_DEBT GenericOrderItemDTO shouldn't be use outside repository.
@Serializable
data class PriceDto(
	/**
	 * if price is 1$
	 * this.price = 1.00
	 */
	@Serializable(with = BigDecimalSerializer::class)
	val price: BigDecimal? = null,
	/**
	 * if price is 1$
	 * this.value = 100
	 */
	val value: Long,
	val currency: CurrencyDto
)