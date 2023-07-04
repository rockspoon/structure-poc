package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral simulation response with the restaurant name and calculations
 * result
 *
 * @param name
 * @param referralSimulationResponse Referral simulation response
 */
@Serializable
data class SimulationResponse(
    val name: String? = null,
    /** Referral simulation response */
    val referralSimulationResponse: ReferralSimulationResponse? = null
)

