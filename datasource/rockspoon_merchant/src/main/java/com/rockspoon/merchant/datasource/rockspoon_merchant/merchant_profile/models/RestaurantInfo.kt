package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Referral restaurant info
 *
 * @param addressLine1
 * @param addressLine2
 * @param city
 * @param country
 * @param name
 * @param newRestaurant
 * @param phoneNumber
 * @param state State in ISO 3166-2 format.
 * @param website
 * @param zipCode
 */
@Serializable
data class RestaurantInfo(
    val addressLine1: String? = null,
    val addressLine2: String? = null,
    val city: String? = null,
    val country: String? = null,
    val name: String? = null,
    val newRestaurant: Boolean? = null,
    val phoneNumber: String? = null,
    /** State in ISO 3166-2 format. */
    val state: String? = null,
    val website: String? = null,
    val zipCode: String? = null
)

