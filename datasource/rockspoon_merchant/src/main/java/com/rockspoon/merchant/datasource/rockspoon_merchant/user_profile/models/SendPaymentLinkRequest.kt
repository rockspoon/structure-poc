package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PhoneDto
import kotlinx.serialization.Serializable

@Serializable
data class SendPaymentLinkRequest(
	val phone: PhoneDto?,
	val email: String?,
	val link: String,
	val orderId: String,
	val venueName: String?
)