package com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaymentRequestDto(
	@SerialName("id")
	val paymentRequestId: String,
	val orderId: String,
	val venueId: String,
	@SerialName("checkIDs")
	val checkIds: List<String>,
	val status: PaymentStatusDto,
	val createdAt: String? = null,
	val updatedAt: String? = null,
	val createdBy: String? = null
)