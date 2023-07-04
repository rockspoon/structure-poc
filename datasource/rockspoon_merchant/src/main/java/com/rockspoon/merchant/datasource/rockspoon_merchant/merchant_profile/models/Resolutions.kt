package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param default
 * @param high
 * @param low
 */
@Serializable
data class Resolutions(
    val default: Resolution? = null,
    val high: Resolution? = null,
    val low: Resolution? = null
)

