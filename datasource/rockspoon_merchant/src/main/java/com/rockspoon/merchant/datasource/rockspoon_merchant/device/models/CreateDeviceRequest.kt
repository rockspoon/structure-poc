package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * CreateDeviceRequest request
 *
 * @param device Device Android UUID
 * @param group Device Group Name
 * @param type
 * @param externalId
 * @param serialNumber
 */
@Serializable
data class CreateDeviceRequest(
    /** Device Android UUID */
    val device: String,
    val type: DeviceType,
    /** Device Group Name */
    val group: String? = null,
    val externalId: String? = null,
    val serialNumber: String? = null
)

