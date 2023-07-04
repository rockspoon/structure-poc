package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
data class TransferOrderToTableRequest(
	val floorPlanSectionID: String,
	val floorPlanElementIDs: Set<String>
)