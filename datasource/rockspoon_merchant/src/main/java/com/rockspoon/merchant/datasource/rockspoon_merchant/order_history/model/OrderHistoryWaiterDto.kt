package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model

import kotlinx.serialization.Serializable

@Serializable
data class OrderHistoryWaiterDto(
	val employeeId: String,
	val name: String
)