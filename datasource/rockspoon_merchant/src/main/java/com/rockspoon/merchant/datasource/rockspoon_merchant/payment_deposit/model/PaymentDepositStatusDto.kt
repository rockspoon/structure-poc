package com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PaymentDepositStatusDto(val value: String) {
	@SerialName("available")
	AVAILABLE("available"),

	@SerialName("applied")
	APPLIED("applied"),

	@SerialName("consumed")
	CONSUMED("consumed")
}