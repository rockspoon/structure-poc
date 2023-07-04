package com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PaymentStatusDto(val value: String) {
    @SerialName("paid")
    PAID("paid"),

    @SerialName("partiallyPaid")
    PARTIALLY_PAID("partiallyPaid"),

    @SerialName("refunded")
    REFUNDED("refunded"),

    @SerialName("awaitingPayment")
    AWAITING_PAYMENT("awaitingPayment");
}