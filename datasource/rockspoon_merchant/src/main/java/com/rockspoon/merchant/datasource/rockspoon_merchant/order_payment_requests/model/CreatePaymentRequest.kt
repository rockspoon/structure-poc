package com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatePaymentRequest(
	val orderId: String,
	@SerialName("checkIDs")
	val checkIds: List<String>
)