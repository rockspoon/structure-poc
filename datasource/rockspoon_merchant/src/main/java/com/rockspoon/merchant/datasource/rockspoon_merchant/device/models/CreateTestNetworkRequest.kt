package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Test network creation data transfer object
 *
 * @param macAddress MAC address of the router
 * @param ssid Network ssid
 * @param password Network password
 */
@Serializable
data class CreateTestNetworkRequest(
    /** MAC address of the router */
    val macAddress: String,
    /** Network ssid */
    val ssid: String,
    /** Network password */
    val password: String
)

