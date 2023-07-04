package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class PaymentInfoDto(
	val isAutoPay: Boolean,
	val lockedByDeviceId: String?
)