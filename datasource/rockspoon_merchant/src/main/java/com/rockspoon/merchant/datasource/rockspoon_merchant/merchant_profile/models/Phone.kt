package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Phone generic phone number
 *
 * @param countryCode
 * @param isDefault
 * @param isValidated
 * @param phoneNumber
 * @param status
 * @param type
 */
@Serializable
data class Phone(
    val countryCode: String? = null,
    val isDefault: Boolean? = null,
    val isValidated: Boolean? = null,
    val phoneNumber: String? = null,
    val status: String? = null,
    val type: String? = null
)

