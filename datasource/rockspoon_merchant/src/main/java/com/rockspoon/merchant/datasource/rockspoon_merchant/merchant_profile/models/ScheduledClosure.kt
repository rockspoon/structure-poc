package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * ScheduledClosure represents scheduled closure model
 *
 * @param period
 * @param reason
 * @param serviceType
 */
@Serializable
data class ScheduledClosure(
    val period: Period? = null,
    val reason: String? = null,
    val serviceType: List<AvailableSalesOption>? = null
)

