package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral simulation request with up to 18 months. The body is a map with
 * the number of the month and the specified object
 */
@Serializable
data class ReferralSimulationRequest(
    val value: String? // Swagger docs error
)

