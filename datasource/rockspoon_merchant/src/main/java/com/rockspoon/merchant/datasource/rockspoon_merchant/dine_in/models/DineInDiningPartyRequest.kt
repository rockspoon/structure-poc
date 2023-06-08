package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.Serializable

@Serializable
class DineInDiningPartyRequest(
	val diners: List<DinnerSessionDto>,
	val floorPlanElementIDs: List<String>,
	val floorPlanSectionId: String,
	val reservationId: String?
)