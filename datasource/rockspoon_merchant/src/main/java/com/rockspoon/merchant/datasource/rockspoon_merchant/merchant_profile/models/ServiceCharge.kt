package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * ServiceCharge represents service charge model
 *
 * @param forPartiesEqualOrLargerThan
 * @param percentage
 * @param effectiveDate
 */
@Serializable
data class ServiceCharge(
    val forPartiesEqualOrLargerThan: Long? = null,
    val percentage: Double? = null,
    val effectiveDate: Instant? = null
)

