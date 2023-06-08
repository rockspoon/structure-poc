package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param next
 * @param previous
 * @param results
 * @param total
 */
@Serializable
data class InlineResponse200(
    val next: String? = null,
    val previous: String? = null,
    val results: List<ReferralTransaction>? = null,
    val total: Int? = null
)

