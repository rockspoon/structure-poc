package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanElementDimensionsDto(
	val width: Float,
	val height: Float
)
