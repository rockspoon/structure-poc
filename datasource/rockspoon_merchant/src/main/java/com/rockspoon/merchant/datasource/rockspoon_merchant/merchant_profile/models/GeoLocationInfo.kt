package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param latitude
 * @param longitude
 */
@Serializable
data class GeoLocationInfo(
    val latitude: Double? = null,
    val longitude: Double? = null
)

