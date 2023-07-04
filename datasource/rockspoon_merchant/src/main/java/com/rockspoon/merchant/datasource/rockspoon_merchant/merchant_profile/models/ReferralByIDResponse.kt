package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral by id response response object
 *
 * @param contactInfo
 * @param email
 * @param invitationLink
 * @param message
 * @param restaurantInfo
 */
@Serializable
data class ReferralByIDResponse(
    val contactInfo: ContactInfo? = null,
    val email: String? = null,
    val invitationLink: String? = null,
    val message: String? = null,
    val restaurantInfo: RestaurantInfo? = null
)

