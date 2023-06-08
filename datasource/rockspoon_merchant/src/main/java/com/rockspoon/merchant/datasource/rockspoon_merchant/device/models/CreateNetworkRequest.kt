package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Network creation data transfer object
 *
 * @param merakiSerialNumber meraki device serial number
 * @param timezone network's timezone
 */
@Serializable
data class CreateNetworkRequest(
    /** meraki device serial number */
    val merakiSerialNumber: String,
    /** network's timezone */
    val timezone: String
)

