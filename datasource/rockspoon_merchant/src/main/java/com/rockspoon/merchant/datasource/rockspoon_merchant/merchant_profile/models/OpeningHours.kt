package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * OpeningHours represents opening hours model
 *
 * @param daysOfWeek
 * @param periods
 */
@Serializable
data class OpeningHours(
    val daysOfWeek: List<String>? = null,
    val periods: List<Period>? = null
)

