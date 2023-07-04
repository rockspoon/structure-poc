package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
class DinnerSessionDto(
	val profileId: String?,
	val seatNumber: String
)