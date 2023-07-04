package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: regular,showCase,demo */
@Serializable
enum class VenueType(val value: String) {

    @SerialName("regular")
    REGULAR("regular"),

    @SerialName("show_case")
    SHOWCASE("show_case"),

    @SerialName("demo")
    DEMO("demo");

}

