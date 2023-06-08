package com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PaymentMethodDto(val value: String) {
	@SerialName("payByLink")
	PAY_BY_LINK("payByLink"),

	@SerialName("paymentTablet")
	PAYMENT_TABLET("paymentTablet")
}