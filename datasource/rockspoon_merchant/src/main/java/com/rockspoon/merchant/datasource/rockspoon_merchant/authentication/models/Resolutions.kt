package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

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

