package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param earn
 * @param earnPerDayOfWeek
 * @param expiresInDays
 * @param redeem
 */
@Serializable
data class VenueCRMLoyalty(
    val earn: VenueCRMLoyaltyScore,
    val expiresInDays: Long,
    val redeem: VenueCRMLoyaltyScore,
    val earnPerDayOfWeek: Map<String, List<VenueCRMDailyLoyaltyScore>>? = null
)

