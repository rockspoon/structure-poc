package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param country
 * @param day
 * @param dayOfWeek
 * @param dayOfWeekCount
 * @param id
 * @param month
 * @param name
 * @param type
 */
@Serializable
data class HolidayResponse(
    val country: String? = null,
    val day: Long? = null,
    val dayOfWeek: String? = null,
    val dayOfWeekCount: String? = null,
    val id: String? = null,
    val month: String? = null,
    val name: String? = null,
    val type: String? = null
)

