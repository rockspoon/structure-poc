package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanElementCapacityDto(
	val min: Short,
	val max: Short,
	val default: Short
)
