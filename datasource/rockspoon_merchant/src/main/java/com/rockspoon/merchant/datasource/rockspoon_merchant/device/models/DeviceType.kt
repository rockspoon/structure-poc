package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DeviceType device type enum Values:
 * fixedPos,mobilePos,qsr,payment,kitchen,runner,printer,bar,grocery,qsrPayment
 */
@Serializable
enum class DeviceType(val value: String) {

    @SerialName("fixed_pos")
    FIXED_POS("fixed_pos"),

    @SerialName("mobile_pos")
    MOBILE_POS("mobile_pos"),

    @SerialName("qsr")
    QSR("qsr"),

    @SerialName("payment")
    PAYMENT("payment"),

    @SerialName("kitchen")
    KITCHEN("kitchen"),

    @SerialName("runner")
    RUNNER("runner"),

    @SerialName("printer")
    PRINTER("printer"),

    @SerialName("bar")
    BAR("bar"),

    @SerialName("grocery")
    GROCERY("grocery"),

    @SerialName("qsr_payment")
    QSR_PAYMENT("qsr_payment");

}

