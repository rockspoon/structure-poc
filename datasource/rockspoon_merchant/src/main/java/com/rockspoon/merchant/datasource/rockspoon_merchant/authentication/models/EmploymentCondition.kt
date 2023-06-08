package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * EmploymentCondition role's employment conditions
 *
 * @param annualSalary
 * @param createdAt
 * @param createdBy
 * @param deletedAt
 * @param deletedBy
 * @param endDate
 * @param hourlyRate
 * @param isOvertimeExempt
 * @param payType
 * @param startDate
 * @param weeklyHours
 */
@Serializable
data class EmploymentCondition(
    @SerialName("AnnualSalary")
    val annualSalary: Salary? = null,
    @SerialName("CreatedAt")
    val createdAt: Instant? = null,
    @SerialName("CreatedBy")
    val createdBy: ObjectID? = null,
    @SerialName("DeletedAt")
    val deletedAt: Instant? = null,
    @SerialName("DeletedBy")
    val deletedBy: ObjectID? = null,
    @SerialName("EndDate")
    val endDate: Instant? = null,
    @SerialName("HourlyRate")
    val hourlyRate: Salary? = null,
    @SerialName("IsOvertimeExempt")
    val isOvertimeExempt: Boolean? = null,
    @SerialName("PayType")
    val payType: String? = null,
    @SerialName("StartDate")
    val startDate: Instant? = null,
    @SerialName("WeeklyHours")
    val weeklyHours: Long? = null
)

