package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param creditScores
 * @param reason
 * @param requesterProfileId
 * @param riskModel
 * @param verifiedAt
 */
@Serializable
data class CreditReport(
    val creditScores: List<CreditScore>? = null,
    val reason: String? = null,
    val requesterProfileId: String? = null,
    val riskModel: List<RiskModel>? = null,
    val verifiedAt: Instant? = null
)

