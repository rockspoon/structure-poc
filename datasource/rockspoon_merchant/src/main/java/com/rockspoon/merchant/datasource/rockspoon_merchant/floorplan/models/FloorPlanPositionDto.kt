package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanPositionDto(
	val x: Float,
	val y: Float,
	val rotation: Float
)
