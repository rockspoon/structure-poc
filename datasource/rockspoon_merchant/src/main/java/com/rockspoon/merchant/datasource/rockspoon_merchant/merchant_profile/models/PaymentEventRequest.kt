package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * PaymentEventRequest represents a payment event request
 *
 * @param eventType Event type.
 */
@Serializable
data class PaymentEventRequest(
    /** Event type. */
    val eventType: EventType
) {

    /** Event type. Values: firstPayment,minimumThreshold */
    @Serializable
    enum class EventType(val value: String) {

        @SerialName("firstPayment")
        FIRSTPAYMENT("firstPayment"),

        @SerialName("minimumThreshold")
        MINIMUMTHRESHOLD("minimumThreshold");

    }

}

