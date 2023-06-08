package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param code
 * @param importance
 */
@Serializable
data class ScoreFactors(
    val code: String? = null,
    val importance: String? = null
)

