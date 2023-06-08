package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FloorPlanSectionStatusDto {
	@SerialName("published")
	PUBLISHED,
	@SerialName("unpublished")
	UNPUBLISHED,

	@Deprecated(replaceWith = ReplaceWith("unpublished"), message = "")
	@SerialName("draft")
	DRAFT
}
