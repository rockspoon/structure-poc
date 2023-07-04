package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param from
 * @param perAmount
 * @param points
 * @param to
 */
@Serializable
data class VenueCRMDailyLoyaltyScore(
    val from: String? = null,
    val perAmount: Double? = null,
    val points: Double? = null,
    val to: String? = null
)

