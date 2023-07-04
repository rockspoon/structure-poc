package com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanSectionOrderStateDto(
	val orderId: String,
	val shortId: String?,
	val status: FloorPlanSectionElementOrderStatusDto?,
	val showNeedAssistanceIcon: Boolean, // if call waiter is true for the table
	val allDinnersAreCa: Boolean, // if all diners in the table have the flag isCA
	val hasCaDiners: Boolean, // if at least one diner in the table has the flag isCA
	val updatedAt: Instant?, // empty if there is no open order
	val notificationCount: Int, // count active order notifications from notification/v1
	val missingItems: List<String>? = null,
	val createdAt: Instant? = null,
	val numberOfItems: Int? = null
)