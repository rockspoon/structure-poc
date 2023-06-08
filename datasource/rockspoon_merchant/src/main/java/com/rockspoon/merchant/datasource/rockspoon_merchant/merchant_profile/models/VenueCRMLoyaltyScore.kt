package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param perAmount
 * @param points
 */
@Serializable
data class VenueCRMLoyaltyScore(
    val perAmount: Double? = null,
    val points: Double? = null
)

