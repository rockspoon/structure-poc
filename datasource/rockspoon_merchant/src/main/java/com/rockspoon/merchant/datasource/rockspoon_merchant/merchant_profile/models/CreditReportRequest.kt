package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * holds reason for requesting credit report check
 *
 * @param reason
 */
@Serializable
data class CreditReportRequest(
    val reason: String
)

