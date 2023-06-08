package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * put extended device configuration (little bit different then post)
 *
 * @param deviceId Device ID
 * @param imei Device IMEI(International Mobile Equipment Identity)
 * @param index Device index for listing
 * @param name Device name
 * @param numberOfColumns Number of columns in device for display purposes
 */
@Serializable
data class PutExtendedDevice(
    /** Device ID */
    val deviceId: String? = null,
    /** Device IMEI(International Mobile Equipment Identity) */
    val imei: String? = null,
    /** Device index for listing */
    val index: Long? = null,
    /** Device name */
    val name: String? = null,
    /** Number of columns in device for display purposes */
    val numberOfColumns: Long? = null
)

