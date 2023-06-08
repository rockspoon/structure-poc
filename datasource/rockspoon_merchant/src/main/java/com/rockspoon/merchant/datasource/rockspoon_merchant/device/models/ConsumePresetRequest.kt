package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * ConsumePresetRequest request
 *
 * @param device Device Android UUID
 * @param uuid QR code
 * @param externalId
 * @param serialNumber
 */
@Serializable
data class ConsumePresetRequest(
    /** Device Android UUID */
    val device: String,
    /** QR code */
    val uuid: String,
    val externalId: String? = null,
    val serialNumber: String? = null
)

