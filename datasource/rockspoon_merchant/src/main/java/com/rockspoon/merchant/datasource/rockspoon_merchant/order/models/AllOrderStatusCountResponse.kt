package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import kotlinx.serialization.Serializable

/**
 * AllOrderStatusCountResponse represents the response oll types or orders status count
 *
 * @param open
 * @param closed
 * @param deleted
 * @param canceled
 * @param draft
 * @param pending
 * @param overdueBalance
 * @param archived
 */
@Serializable
data class AllOrderStatusCountResponse(
	val open: Int? = null,
	val closed: Int? = null,
	val deleted: Int? = null,
	val canceled: Int? = null,
	val draft: Int? = null,
	val pending: Int? = null,
	val overdueBalance: Int? = null,
	val archived: Int? = null
)
