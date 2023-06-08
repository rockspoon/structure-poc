package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * ServiceRange represents service range model
 *
 * @param area
 * @param radius
 * @param type
 */
@Serializable
data class ServiceRange(
    val area: List<kotlin.Float>? = null,
    val radius: kotlin.Float? = null,
    val type: RangeType? = null
)

