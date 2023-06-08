package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
class FloorPlanLocationDto(
	val floorPlanElementIDs: List<String>,
	val floorPlanSectionId: String?
)