package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * CreateTestDeviceRequest request
 *
 * @param deviceId device Id
 * @param failOn microservices to fail
 */
@Serializable
data class CreateTestDeviceRequest(
    /** device Id */
    val deviceId: String? = null,
    /** microservices to fail */
    val failOn: List<String>? = null
)

