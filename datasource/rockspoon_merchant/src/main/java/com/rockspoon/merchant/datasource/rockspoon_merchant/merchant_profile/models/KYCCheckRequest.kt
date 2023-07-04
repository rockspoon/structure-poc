package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * holds reason for requesting KYC check
 *
 * @param reason
 */
@Serializable
data class KYCCheckRequest(
    val reason: String
)

