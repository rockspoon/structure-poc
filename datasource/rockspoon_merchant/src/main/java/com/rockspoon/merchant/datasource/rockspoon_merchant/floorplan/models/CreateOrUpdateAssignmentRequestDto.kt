package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.serialization.Serializable

@Serializable
data class CreateOrUpdateAssignmentRequestDto(
	val elementIds: List<String>,
	val assignedTo: List<String>,
	val color: String
)
