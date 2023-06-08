package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Alert definitions for the device
 *
 * @param beepOnArrival Flag that indicates if the device will beep on
 *     arrival
 * @param isEnable Flag that indicates if the device is enabled
 * @param minutesUntilLongBeep Time in minutes until a long beep
 * @param textColorAfterLongBeep Text color after a long beep
 */
@Serializable
data class Alert(
    /** Flag that indicates if the device will beep on arrival */
    val beepOnArrival: Boolean? = null,
    /** Flag that indicates if the device is enabled */
    val isEnable: Boolean? = null,
    /** Time in minutes until a long beep */
    val minutesUntilLongBeep: Int? = null,
    /** Text color after a long beep */
    val textColorAfterLongBeep: String? = null
)

