package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * CapacityConfig represents config struct for capacity
 *
 * @param configPerDayOfWeek
 * @param intervalInMinutes
 */
@Serializable
data class CapacityConfig(
    val configPerDayOfWeek: List<ConfigPerDay>,
    val intervalInMinutes: Long
)

