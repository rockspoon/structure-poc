package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param revenueAmount the accumulated revenue amount for the current
 *     month in cents
 * @param dailyRevenueAmount the daily revenue amount in cents
 * @param anniversary
 */
@Serializable
data class ReferralBonusUpdateRequest(
    /** the accumulated revenue amount for the current month in cents */
    val revenueAmount: Long,
    /** the daily revenue amount in cents */
    val dailyRevenueAmount: Long? = null,
    val anniversary: Instant? = null
)

