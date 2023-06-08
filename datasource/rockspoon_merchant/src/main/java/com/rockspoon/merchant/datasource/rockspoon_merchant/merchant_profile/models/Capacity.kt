package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param delivery
 * @param kitchenOutput
 * @param seating
 */
@Serializable
data class Capacity(
    val delivery: CapacityConfig? = null,
    val kitchenOutput: CapacityConfig? = null,
    val seating: CapacityConfig? = null
)

