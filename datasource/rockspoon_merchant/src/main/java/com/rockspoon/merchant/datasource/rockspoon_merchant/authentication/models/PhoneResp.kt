package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * PhoneResp generic phone number
 *
 * @param countryCode
 * @param isDefault
 * @param isValidated
 * @param phoneNumber
 * @param status
 * @param type
 */
@Serializable
data class PhoneResp(
    val countryCode: String? = null,
    val isDefault: Boolean? = null,
    val isValidated: Boolean? = null,
    val phoneNumber: String? = null,
    val status: String? = null,
    val type: String? = null
)

