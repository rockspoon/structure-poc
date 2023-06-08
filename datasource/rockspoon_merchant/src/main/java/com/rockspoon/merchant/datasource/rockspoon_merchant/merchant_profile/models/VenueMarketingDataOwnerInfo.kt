package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param phone
 * @param email
 * @param nationality
 * @param linkedIn
 * @param facebook
 * @param twitter
 * @param instagram
 */
@Serializable
data class VenueMarketingDataOwnerInfo(
    val phone: String? = null,
    val email: String? = null,
    val nationality: String? = null,
    val linkedIn: String? = null,
    val facebook: String? = null,
    val twitter: String? = null,
    val instagram: String? = null
)

