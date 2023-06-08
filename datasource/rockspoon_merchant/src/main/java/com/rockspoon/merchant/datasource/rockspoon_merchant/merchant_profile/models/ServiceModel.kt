package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Values: counter,table,both */
@Serializable
enum class ServiceModel(val value: String) {

    @SerialName("counter")
    COUNTER("counter"),

    @SerialName("table")
    TABLE("table"),

    @SerialName("both")
    BOTH("both");
}