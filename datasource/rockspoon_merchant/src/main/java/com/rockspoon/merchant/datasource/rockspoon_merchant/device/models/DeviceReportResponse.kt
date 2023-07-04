package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * DeviceReport response
 *
 * @param deviceId Device ID
 * @param name Device name
 * @param type Device type
 * @param installationDate Installation date
 */
@Serializable
data class DeviceReportResponse(
    /** Device ID */
    val deviceId: String? = null,
    /** Device name */
    val name: String? = null,
    /** Device type */
    val type: String? = null,
    /** Installation date */
    val installationDate: Instant? = null
)

