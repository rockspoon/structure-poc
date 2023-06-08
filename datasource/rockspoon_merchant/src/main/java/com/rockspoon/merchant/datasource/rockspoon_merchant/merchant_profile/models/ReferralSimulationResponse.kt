package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral simulation request. The body is a map with the number of the
 * month and the specified object
 */
@Serializable
data class ReferralSimulationResponse(
    val value: String // Swagger doc error
)

