package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param comments
 * @param reviewResult
 */
@Serializable
data class ManualReviewRequest(
    val comments: String? = null,
    val reviewResult: Boolean? = null
)

