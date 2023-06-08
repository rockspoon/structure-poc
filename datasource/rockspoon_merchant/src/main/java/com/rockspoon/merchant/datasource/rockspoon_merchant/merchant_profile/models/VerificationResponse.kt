package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * VerificationResponse verification response for kyc and credit check
 * history
 *
 * @param creditStatus
 * @param errors
 * @param kycStatus
 */
@Serializable
data class VerificationResponse(
    val creditStatus: VerificationStatus? = null,
    val errors: List<VerificationError>? = null,
    val kycStatus: VerificationStatus? = null
)

