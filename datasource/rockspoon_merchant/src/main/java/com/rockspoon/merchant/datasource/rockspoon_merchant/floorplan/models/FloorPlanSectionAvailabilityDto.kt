package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanSectionAvailabilityDTO(
	val daysOfWeek: List<DayOfWeekDto?>?,
	val periods: List<AvailabilityPeriodDTO>?
)

@Serializable
data class AvailabilityPeriodDTO(
	val from: String,
	val to: String
)
