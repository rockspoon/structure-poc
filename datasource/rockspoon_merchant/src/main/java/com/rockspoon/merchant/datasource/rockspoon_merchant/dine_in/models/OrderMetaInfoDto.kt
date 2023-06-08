package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class OrderMetaInfoDto(
	val attendedBy: String,
	val orderId: String,
	val floorPlanLocation: FloorPlanLocationDto
)