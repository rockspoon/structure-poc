package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
class FloorPlanSectionWithIndexDto(
	val id: String,
	val index: Int
)