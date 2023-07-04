package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param planName
 * @param summary
 * @param summary2
 * @param rockspoonFees
 * @param availableFeatures
 * @param contractIds
 */
@Serializable
data class RockspoonPlanRequest(
    val planName: String? = null,
    val summary: String? = null,
    val summary2: String? = null,
    val rockspoonFees: List<RockspoonFee>? = null,
    val availableFeatures: List<String>? = null,
    val contractIds: List<String>? = null
)

