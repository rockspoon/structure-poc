package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Request to change network status
 *
 * @param ssid SSID
 */
@Serializable
data class NetworkStatusActivateRequest(
    /** SSID */
    val ssid: String
)

