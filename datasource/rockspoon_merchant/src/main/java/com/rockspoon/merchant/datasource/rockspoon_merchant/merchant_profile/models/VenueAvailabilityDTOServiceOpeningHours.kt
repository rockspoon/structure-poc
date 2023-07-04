package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param deliveryAvailability
 * @param curbsideAvailability
 * @param takeoutAvailability
 */
@Serializable
data class VenueAvailabilityDTOServiceOpeningHours(
    val deliveryAvailability: List<OpeningHours>? = null,
    val curbsideAvailability: List<OpeningHours>? = null,
    val takeoutAvailability: List<OpeningHours>? = null
)

