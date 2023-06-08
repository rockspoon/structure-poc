package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral contact Info
 *
 * @param name
 * @param phoneNumber
 */
@Serializable
data class ContactInfo(
    val name: String? = null,
    val phoneNumber: String? = null
)

