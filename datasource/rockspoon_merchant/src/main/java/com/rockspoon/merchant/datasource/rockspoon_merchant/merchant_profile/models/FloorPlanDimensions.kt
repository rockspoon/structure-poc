package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param height Element height
 * @param width Element width
 */
@Serializable
data class FloorPlanDimensions(
    /** Element height */
    val height: kotlin.Float? = null,
    /** Element width */
    val width: kotlin.Float? = null
)

