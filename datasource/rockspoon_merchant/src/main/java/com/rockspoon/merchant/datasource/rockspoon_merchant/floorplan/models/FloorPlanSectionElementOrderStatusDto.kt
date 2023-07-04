package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FloorPlanSectionElementOrderStatusDto {
	@SerialName("waiting")
	WAITING,

	@SerialName("dining")
	DINING,

	@SerialName("paying")
	PAYING,

	@SerialName("paid")
	PAID

}