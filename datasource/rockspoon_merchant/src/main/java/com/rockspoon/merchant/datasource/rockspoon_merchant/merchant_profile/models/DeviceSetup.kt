package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param tokenExpirationDate
 * @param venueToken
 */
@Serializable
data class DeviceSetup(
    val tokenExpirationDate: Instant? = null,
    val venueToken: String? = null
)

