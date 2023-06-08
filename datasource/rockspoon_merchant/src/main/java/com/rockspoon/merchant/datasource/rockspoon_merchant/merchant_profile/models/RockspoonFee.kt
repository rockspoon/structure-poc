package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param title
 * @param serviceType
 * @param consumer
 * @param threshold
 * @param fixed
 * @param percentage
 */
@Serializable
data class RockspoonFee(
    val title: String? = null,
    val serviceType: List<AvailableSalesOption>? = null,
    val consumer: Boolean? = null,
    val threshold: Long? = null,
    val fixed: Long? = null,
    val percentage: Double? = null
)

