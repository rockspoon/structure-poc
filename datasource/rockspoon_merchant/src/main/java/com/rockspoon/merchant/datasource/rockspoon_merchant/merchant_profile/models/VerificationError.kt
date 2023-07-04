package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * VerificationError verification error description
 *
 * @param code
 * @param message
 * @param name
 * @param type
 */
@Serializable
data class VerificationError(
    val code: String? = null,
    val message: String? = null,
    val name: String? = null,
    val type: VerificationErrorType? = null
)

