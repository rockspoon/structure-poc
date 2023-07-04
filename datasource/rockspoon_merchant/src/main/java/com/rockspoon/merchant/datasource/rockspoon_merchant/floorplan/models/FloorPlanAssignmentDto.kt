package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
class FloorPlanAssignmentDto(
	val id: String,
	val elementIds: List<String>,
	val assignedTo: List<String>,
	val color: String
)
