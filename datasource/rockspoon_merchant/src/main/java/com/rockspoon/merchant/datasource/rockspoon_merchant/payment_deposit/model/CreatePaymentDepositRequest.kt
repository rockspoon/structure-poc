package com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class CreatePaymentDepositRequest(
	val customerPhone: String,
	val customerName: String,
	val eventDate: Instant,
	val eventDescription: String,
	val invitees: Int,
	val paymentId: String
)