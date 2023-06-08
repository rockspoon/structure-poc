package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param rebootTimes
 * @param releaseTimes
 * @param reconnectTimes
 */
@Serializable
data class UpdateDeviceConfigRequest(
    val rebootTimes: List<String>? = null,
    val releaseTimes: List<String>? = null,
    val reconnectTimes: List<String>? = null
)

