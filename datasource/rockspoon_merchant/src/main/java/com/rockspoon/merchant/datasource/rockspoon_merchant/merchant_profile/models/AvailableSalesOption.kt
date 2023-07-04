package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: DINE_IN,takeout,delivery,catering,curbside,qsr */
@Serializable
enum class AvailableSalesOption(val value: String) {

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

