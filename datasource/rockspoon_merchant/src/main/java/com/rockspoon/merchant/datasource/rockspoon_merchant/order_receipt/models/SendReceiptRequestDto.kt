package com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt.models

import kotlinx.serialization.Serializable

@Serializable
data class SendReceiptRequestDto(
	val email: String?,
	val phone: String?,
	val securityDepositId: String?,
	val giftCardReceipt: Boolean? = null //only for payment
)