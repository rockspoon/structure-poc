package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param discountType
 * @param value
 */
@Serializable
data class VenueCRMOffer(
    val discountType: VenueOfferDiscountType,
    val value: Long
)

