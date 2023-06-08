@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

/**
 * @param day
 * @param time
 */
@Serializable
data class TimeProgressiveValue(
    val day: Day? = null,
    val time: String? = null
) {

    /** Values: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY */
    @Serializable
    enum class Day(val value: String) {

        @SerialName("MONDAY")
        MONDAY("MONDAY"),

        @SerialName("TUESDAY")
        TUESDAY("TUESDAY"),

        @SerialName("WEDNESDAY")
        WEDNESDAY("WEDNESDAY"),

        @SerialName("THURSDAY")
        THURSDAY("THURSDAY"),

        @SerialName("FRIDAY")
        FRIDAY("FRIDAY"),

        @SerialName("SATURDAY")
        SATURDAY("SATURDAY"),

        @SerialName("SUNDAY")
        SUNDAY("SUNDAY");

    }

}

