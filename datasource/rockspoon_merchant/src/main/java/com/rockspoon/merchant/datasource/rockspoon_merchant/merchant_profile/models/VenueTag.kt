package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param name
 * @param type
 */
@Serializable
data class VenueTag(
    val name: String? = null,
    val type: Type? = null
) {

    /** Values: property,facility,paymentMethod,cuisine */
    @Serializable
    enum class Type(val value: String) {

        @SerialName("property")
        PROPERTY("property"),

        @SerialName("facility")
        FACILITY("facility"),

        @SerialName("payment_method")
        PAYMENTMETHOD("payment_method"),

        @SerialName("cuisine")
        CUISINE("cuisine");

    }

}

