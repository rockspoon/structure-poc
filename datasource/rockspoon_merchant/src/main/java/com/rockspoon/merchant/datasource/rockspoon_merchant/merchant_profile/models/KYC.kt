package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param errorReference
 * @param failedOfac
 * @param giactResponse
 * @param reason
 * @param requesterProfileId
 * @param verifiedAt
 */
@Serializable
data class KYC(
    val errorReference: String? = null,
    val failedOfac: Boolean? = null,
    val giactResponse: GiactResponse? = null,
    val reason: String? = null,
    val requesterProfileId: String? = null,
    val verifiedAt: Instant? = null
)

