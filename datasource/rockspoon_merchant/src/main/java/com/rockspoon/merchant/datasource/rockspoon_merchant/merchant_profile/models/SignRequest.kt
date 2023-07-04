package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param mode
 * @param geoLocationInfo
 */
@Serializable
data class SignRequest(
    val mode: Mode,
    val geoLocationInfo: GeoLocationInfo? = null
) {

    /** Values: sign,view */
    @Serializable
    enum class Mode(val value: String) {

        @SerialName("sign")
        SIGN("sign"),

        @SerialName("view")
        VIEW("view");

    }

}

