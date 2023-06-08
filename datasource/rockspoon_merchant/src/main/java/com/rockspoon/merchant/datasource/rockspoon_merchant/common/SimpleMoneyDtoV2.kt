package com.rockspoon.merchant.datasource.rockspoon_merchant.common

import java.math.BigDecimal

//TODO by Oleg temporary solution to test Payment API V2. Remove this class as soon as possible
@Deprecated("use SimpleMoneyDto")
data class SimpleMoneyDtoV2(
	val amount: BigDecimal,
	val symbol: String
)