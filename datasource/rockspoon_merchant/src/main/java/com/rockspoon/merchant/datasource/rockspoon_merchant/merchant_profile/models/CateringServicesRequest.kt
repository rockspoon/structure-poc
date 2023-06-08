package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param advanceNotice
 * @param fee
 * @param orderMinimumAmount
 * @param range
 */
@Serializable
data class CateringServicesRequest(
    val advanceNotice: AdvanceNotice? = null,
    val fee: Fee? = null,
    val orderMinimumAmount: Long? = null,
    val range: ServiceRange? = null
)

