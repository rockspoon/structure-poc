package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param rebootTimes reboot times based on the venue timezone
 * @param releaseTimes release times based on the venue timezone
 * @param reconnectTimes reconnect times based on the venue timezone
 */
@Serializable
data class DeviceConfig(
    /** reboot times based on the venue timezone */
    val rebootTimes: List<String>? = null,
    /** release times based on the venue timezone */
    val releaseTimes: List<String>? = null,
    /** reconnect times based on the venue timezone */
    val reconnectTimes: List<String>? = null
)

