package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: amount,percentage,distance */
@Serializable
enum class FeeType(val value: String) {

    @SerialName("amount")
    AMOUNT("amount"),

    @SerialName("percentage")
    PERCENTAGE("percentage"),

    @SerialName("distance")
    DISTANCE("distance");

}

