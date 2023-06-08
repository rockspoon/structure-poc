package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class TransferOrderToWaiterRequest(
	val waiterId: String,
	val orderIds: List<String>,
	val reassignTime: Instant
)

@Serializable
data class TransferSingleOrderToWaiterManagerRequest(
	val orderId: String,
	val reassignTime: Instant
)

@Serializable
data class TransferOrdersToWaiterAsManagerRequest(
	val waiterId: String,
	val orders: List<TransferSingleOrderToWaiterManagerRequest>
)