package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param firstName
 * @param lastName
 * @param email
 */
@Serializable
data class ReferralInvitationUser(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null
)

