package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Network data transfer object
 *
 * @param lastUpdatedAt Last updated at date time
 * @param password Network password
 * @param ssid Network ssid
 * @param type Network type
 * @param status Network status
 */
@Serializable
data class Network(
    /** Last updated at date time */
    val lastUpdatedAt: Instant,
    /** Network password */
    val password: String,
    /** Network ssid */
    val ssid: String,
    /** Network type */
    val type: Type,
    /** Network status */
    val status: Status? = null
) {

    /** Network type Values: client,service */
    @Serializable
    enum class Type(val value: String) {

        @SerialName("client")
        CLIENT("client"),

        @SerialName("service")
        SERVICE("service");

    }

    /** Network status Values: active,inactive */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("active")
        ACTIVE("active"),

        @SerialName("inactive")
        INACTIVE("inactive");

    }

}

