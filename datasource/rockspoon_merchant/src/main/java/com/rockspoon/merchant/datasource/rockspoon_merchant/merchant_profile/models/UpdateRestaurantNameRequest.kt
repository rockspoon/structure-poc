package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param name BE Name.
 * @param jobDescription
 */
@Serializable
data class UpdateRestaurantNameRequest(
    /** BE Name. */
    val name: String,
    val jobDescription: String? = null
)

