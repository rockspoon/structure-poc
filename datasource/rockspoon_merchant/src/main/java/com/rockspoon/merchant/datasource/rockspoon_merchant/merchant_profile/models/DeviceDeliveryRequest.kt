package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param deliveryDate
 * @param devices
 * @param totalDelivered
 * @param extraEmails
 */
@Serializable
data class DeviceDeliveryRequest(
    val deliveryDate: Instant? = null,
    val devices: List<Device>? = null,
    val totalDelivered: Long? = null,
    val extraEmails: List<String>? = null
)

