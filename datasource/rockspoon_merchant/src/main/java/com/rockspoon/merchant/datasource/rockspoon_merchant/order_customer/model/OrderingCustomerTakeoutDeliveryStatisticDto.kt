package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import kotlinx.serialization.Serializable

@Serializable
data class OrderingCustomerTakeoutDeliveryStatisticDto(
	val takeout: Int?,
	val curbside: Int?,
	val delivery: Int?,
	val qsr: Int?
)
