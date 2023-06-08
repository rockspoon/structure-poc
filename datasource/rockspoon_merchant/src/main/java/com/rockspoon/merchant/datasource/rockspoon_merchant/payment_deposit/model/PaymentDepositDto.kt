package com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.SimpleMoneyDto
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class PaymentDepositDto(
	val id: String,
	val paymentId: String,
	val venueId: String,
	val orderId: String?,
	val orderShortId: String,
	val shortId: String,
	val checkId: String?,
	val amount: SimpleMoneyDto,
	val status: PaymentDepositStatusDto,
	val eventDate: Instant,
	val customerPhone: String,
	val customerName: String,
	val eventDescription: String,
	val consumed: SimpleMoneyDto,
	val invitees: Int
)