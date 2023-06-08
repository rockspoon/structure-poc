package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param expirationDate
 * @param password
 * @param ssid
 * @param token
 * @param venueId
 */
@Serializable
data class DeviceSetupResponse(
    val expirationDate: Instant? = null,
    val password: String? = null,
    val ssid: String? = null,
    val token: String? = null,
    val venueId: ObjectID? = null
)

