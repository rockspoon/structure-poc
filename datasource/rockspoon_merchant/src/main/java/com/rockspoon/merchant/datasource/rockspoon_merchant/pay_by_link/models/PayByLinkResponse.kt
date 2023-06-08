package com.rockspoon.merchant.datasource.rockspoon_merchant.pay_by_link.models

import kotlinx.serialization.Serializable

@Serializable
data class PayByLinkResponse(
	val link: String,
	val shadowUserId: String
)