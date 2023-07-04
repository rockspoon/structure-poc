package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param rotation Element rotation
 * @param x X position.
 * @param y Y position
 */
@Serializable
data class FloorPlanElementPositionResponse(
    /** Element rotation */
    val rotation: kotlin.Float? = null,
    /** X position. */
    val x: kotlin.Float? = null,
    /** Y position */
    val y: kotlin.Float? = null
)

