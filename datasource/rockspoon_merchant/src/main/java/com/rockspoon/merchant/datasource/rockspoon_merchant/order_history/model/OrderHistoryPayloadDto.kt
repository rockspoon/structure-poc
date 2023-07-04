package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.SimpleMoneyDto
import kotlinx.serialization.Serializable

@Serializable
data class OrderHistoryPayloadDto(
	val waiter: OrderHistoryWaiterDto?,
	val outstandingBalance: SimpleMoneyDto?,
	val receiver: String?,
	val tips: SimpleMoneyDto?
)