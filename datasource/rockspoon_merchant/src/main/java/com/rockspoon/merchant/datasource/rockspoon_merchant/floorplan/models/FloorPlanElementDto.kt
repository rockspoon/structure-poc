package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanElementDto(
	val elementId: String? = null,
	val type: FloorPlanElementTypeDto,
	val name: String,
	val dimensions: FloorPlanElementDimensionsDto? = null,
	val position: FloorPlanPositionDto,
	val capacity: FloorPlanElementCapacityDto? = null,
	val elements: List<FloorPlanElementDto>? = emptyList(),
	val availableForReservation: Boolean,
	val isBlocked: Boolean
)