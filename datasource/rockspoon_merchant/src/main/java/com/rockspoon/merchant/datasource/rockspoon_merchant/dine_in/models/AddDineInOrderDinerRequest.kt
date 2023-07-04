package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class AddDineInOrderDinerRequest(
	val profileId: String?,
	val seatNumber: String?
)