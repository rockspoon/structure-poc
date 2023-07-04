package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param model
 * @param serialNumber
 * @param type
 */
@Serializable
data class Device(
    val model: String? = null,
    val serialNumber: String? = null,
    val type: Type? = null
) {

    /** Values: router,pos,printer */
    @Serializable
    enum class Type(val value: String) {

        @SerialName("router")
        ROUTER("router"),

        @SerialName("pos")
        POS("pos"),

        @SerialName("printer")
        PRINTER("printer");

    }

}

