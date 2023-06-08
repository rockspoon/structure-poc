package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param delivery
 * @param takeout
 */
@Serializable
data class VenueMarketingDataServices(
    val delivery: Boolean? = null,
    val takeout: Boolean? = null
)

