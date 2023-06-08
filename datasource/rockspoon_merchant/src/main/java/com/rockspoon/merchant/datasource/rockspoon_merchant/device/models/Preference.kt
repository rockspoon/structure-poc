package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Preference data transfer object
 *
 * @param display
 * @param extendedDevices
 * @param extensionIndex Index of the extesion
 * @param font
 */
@Serializable
data class Preference(
    val display: Display? = null,
    val extendedDevices: List<ExtendedDevice>? = null,
    /** Index of the extesion */
    val extensionIndex: Long? = null,
    val font: Font? = null
)

