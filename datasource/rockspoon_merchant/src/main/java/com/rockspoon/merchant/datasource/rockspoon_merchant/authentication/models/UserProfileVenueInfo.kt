package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param endDate
 * @param startDate
 */
@Serializable
data class UserProfileVenueInfo(
    val endDate: Instant? = null,
    val startDate: Instant? = null
)

