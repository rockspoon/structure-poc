package com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt.models

import kotlinx.serialization.Serializable

@Serializable
data class PrintingJobPayloadDto(
	val printPayload: String,
	val ipAddress: String,
	val printerModel: String,
	val describeMessage: String
)