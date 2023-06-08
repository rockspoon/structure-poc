package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral request object
 *
 * @param contactInfo
 * @param email
 * @param message
 * @param restaurantInfo
 */
@Serializable
data class ReferralUpdateRequest(
    val contactInfo: ContactInfo? = null,
    val email: String? = null,
    val message: String? = null,
    val restaurantInfo: RestaurantInfo? = null
)

