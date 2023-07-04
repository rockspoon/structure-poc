package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VenueParkingDTO represents DTO of venue parking model
 *
 * @param address
 * @param type
 * @param useVenueAddress
 * @param serviceType
 */
@Serializable
data class VenueParkingDTO(
    val address: Address? = null,
    val type: VenueParkingType? = null,
    val useVenueAddress: Boolean? = null,
    val serviceType: ServiceType? = null
) {

    /** Values: DINE_IN,takeout,delivery,catering,curbside,qsr */
    @Serializable
    enum class ServiceType(val value: String) {

        @SerialName("dine-in")
        DINE_IN("dine-in"),

        @SerialName("takeout")
        TAKEOUT("takeout"),

        @SerialName("delivery")
        DELIVERY("delivery"),

        @SerialName("catering")
        CATERING("catering"),

        @SerialName("curbside")
        CURBSIDE("curbside"),

        @SerialName("qsr")
        QSR("qsr");

    }

}

