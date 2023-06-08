package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models.FloorPlanElementTypeDto
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardMetaDto(
	val orderId: String,
	val orderShortId: String,
	val tableName: String?,
	@SerialName("preparationTime")
	val preparationTimeInSeconds: Long,
	val type: KitchenCardTypeDto,
	val tableType: FloorPlanElementTypeDto?,
	val tableNumbers: List<String>?,
	val isAvailable: Boolean?,
	val routing: List<String>?,
	val unavailabilityReason: String?,
	val pickupTime: Instant?,
	val customerAllergens: List<KitchenCardCustomerAllergenDto>?
)