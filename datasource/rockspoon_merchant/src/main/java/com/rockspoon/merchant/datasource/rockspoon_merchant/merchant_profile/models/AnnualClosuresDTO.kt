package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * AnnualClosuresDTO represents DTO of annual closures model
 *
 * @param closedAllDay
 * @param date
 * @param holidayId
 * @param modifiedOpeningHours
 * @param name
 * @param serviceType
 * @param type
 */
@Serializable
data class AnnualClosuresDTO(
    val closedAllDay: Boolean? = null,
    val date: String? = null,
    val holidayId: String? = null,
    val modifiedOpeningHours: Period? = null,
    val name: String? = null,
    val serviceType: List<AvailableSalesOption>? = null,
    val type: HolidayType? = null
)

