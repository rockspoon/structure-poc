package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.serialization.Serializable

@Serializable
class DineInOrderSummaryDto(
	val dineInOrderId: String,
	val attendedBy: String,
	val floorPlanLocation: FloorPlanLocationDto,
	val total: PriceDto,
	val paymentInfo: PaymentInfoDto?,
	val shortId: String
)