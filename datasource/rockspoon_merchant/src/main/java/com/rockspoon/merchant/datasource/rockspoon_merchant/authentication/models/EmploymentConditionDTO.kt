package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * EmploymentConditionDTO represents DTO of role's employment conditions
 *
 * @param annualSalary
 * @param endDate
 * @param hourlyRate
 * @param isOvertimeExempt
 * @param payType
 * @param startDate
 * @param weeklyHours
 */
@Serializable
data class EmploymentConditionDTO(
    val annualSalary: Salary? = null,
    val endDate: Instant? = null,
    val hourlyRate: Salary? = null,
    val isOvertimeExempt: Boolean? = null,
    val payType: String? = null,
    val startDate: Instant? = null,
    val weeklyHours: Long? = null
)

