package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param discountType
 * @param from
 * @param to
 * @param value
 */
@Serializable
data class VenueCRMHourlySpecial(
    val discountType: VenueOfferDiscountType,
    val from: String,
    val to: String,
    val value: Long
)

