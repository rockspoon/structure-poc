package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VenueAvailabilityDTO represents DTO of venue availability model
 *
 * @param annualClosures
 * @param openingHours
 * @param restaurantStatus
 * @param serviceOpeningHours
 * @param scheduledClosures
 * @param scheduledClosureList
 */
@Serializable
data class VenueAvailabilityDTO(
    val annualClosures: List<AnnualClosuresDTO>? = null,
    val openingHours: List<OpeningHours>? = null,
    val restaurantStatus: RestaurantStatus? = null,
    val serviceOpeningHours: VenueAvailabilityDTOServiceOpeningHours? = null,
    val scheduledClosures: ScheduledClosure? = null,
    val scheduledClosureList: List<ScheduledClosure>? = null
) {

    /** Values: fullyOperational,preOperational,closed,temporarilyClosed */
    @Serializable
    enum class RestaurantStatus(val value: String) {

        @SerialName("fullyOperational")
        FULLYOPERATIONAL("fullyOperational"),

        @SerialName("preOperational")
        PREOPERATIONAL("preOperational"),

        @SerialName("closed")
        CLOSED("closed"),

        @SerialName("temporarilyClosed")
        TEMPORARILYCLOSED("temporarilyClosed");

    }

}

