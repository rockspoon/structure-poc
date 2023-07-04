package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanSectionWithOrderDto(
	val sectionId: String?,
	val name: String,
	val type: List<FloorPlanSectionTypeDto?>?,
	val availability: List<FloorPlanSectionAvailabilityDTO>?,
	val status: FloorPlanSectionStatusDto,
	val elements: List<FloorPlanElementWithOrderDto>,
	val shortName: String?,
	val index: Int?
)
