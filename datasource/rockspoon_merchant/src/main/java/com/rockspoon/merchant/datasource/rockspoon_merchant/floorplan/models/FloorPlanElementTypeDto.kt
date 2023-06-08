package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FloorPlanElementTypeDto {
	@SerialName("round_bar_area")
	ROUND_BAR_AREA,

	@SerialName("square_bar_area")
	SQUARE_BAR_AREA,

	@SerialName("wall")
	WALL,

	@SerialName("window")
	WINDOW,

	@SerialName("round_table")
	ROUND_TABLE,

	@SerialName("square_table")
	SQUARE_TABLE,

	@SerialName("round_standing_table")
	ROUND_STANDING_TABLE,

	@SerialName("square_standing_table")
	SQUARE_STANDING_TABLE,

	@SerialName("bar_seat")
	BAR_SEAT
}