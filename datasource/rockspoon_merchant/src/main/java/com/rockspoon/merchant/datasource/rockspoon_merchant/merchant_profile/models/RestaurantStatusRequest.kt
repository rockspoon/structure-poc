package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param restaurantStatus */
@Serializable
data class RestaurantStatusRequest(
    val restaurantStatus: RestaurantStatus? = null
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

