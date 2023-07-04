package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FloorPlanSectionTypeDto {
	@SerialName("wheelchair")
	WHEELCHAIR,
	@SerialName("indoor")
	INDOOR,
	@SerialName("outdoor")
	OUTDOOR,
	@SerialName("rooftop")
	ROOFTOP
}