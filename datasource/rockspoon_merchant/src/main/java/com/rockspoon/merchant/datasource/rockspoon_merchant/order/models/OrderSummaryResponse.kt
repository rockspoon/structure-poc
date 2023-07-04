package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import kotlinx.serialization.Serializable

/**
 * OrdersByTypeStatusCount represents orders by type and their statuses count.
 *
 * @param curbside
 * @param dineIn
 * @param qsr
 * @param delivery
 * @param takeout
 * @param giftCard
 *
 */

@Serializable
data class OrderSummaryResponse(
	val curbside: AllOrderStatusCountResponse? = null,
	val dineIn: AllOrderStatusCountResponse? = null,
	val qsr: AllOrderStatusCountResponse? = null,
	val delivery: AllOrderStatusCountResponse? = null,
	val takeout: AllOrderStatusCountResponse? = null,
	val giftCard: AllOrderStatusCountResponse? = null
)