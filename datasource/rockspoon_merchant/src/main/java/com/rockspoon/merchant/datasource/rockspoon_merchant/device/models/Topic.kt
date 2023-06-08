package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Attribute to determine what the printer is responsible for Values:
 * receipt,kitchen,service,runner,bag,DINE_IN,qsr,delivery,takeout,curbside
 */
@Serializable
enum class Topic(val value: String) {

    @SerialName("receipt")
    RECEIPT("receipt"),

    @SerialName("kitchen")
    KITCHEN("kitchen"),

    @SerialName("service")
    SERVICE("service"),

    @SerialName("runner")
    RUNNER("runner"),

    @SerialName("bag")
    BAG("bag"),

    @SerialName("dine-in")
    DINE_IN("dine-in"),

    @SerialName("qsr")
    QSR("qsr"),

    @SerialName("delivery")
    DELIVERY("delivery"),

    @SerialName("takeout")
    TAKEOUT("takeout"),

    @SerialName("curbside")
    CURBSIDE("curbside");

}

