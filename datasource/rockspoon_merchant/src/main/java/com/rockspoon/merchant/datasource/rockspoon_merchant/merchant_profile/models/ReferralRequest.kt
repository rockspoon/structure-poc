package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral request object
 *
 * @param contactInfo
 * @param email
 * @param restaurantInfo
 */
@Serializable
data class ReferralRequest(
    val contactInfo: ContactInfo,
    val email: String,
    val restaurantInfo: RestaurantInfo? = null
)

