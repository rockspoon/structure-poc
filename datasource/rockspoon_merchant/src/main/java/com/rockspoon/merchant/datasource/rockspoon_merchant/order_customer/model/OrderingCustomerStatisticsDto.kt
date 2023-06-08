package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
class OrderingCustomerStatisticsDto(
	val lastVisit: Instant?,
	val numberOfVisits: Int,
	@Serializable(with = BigDecimalSerializer::class)
	val avgAmountSpent: BigDecimal?,
	val avgPartySize: Float?
)