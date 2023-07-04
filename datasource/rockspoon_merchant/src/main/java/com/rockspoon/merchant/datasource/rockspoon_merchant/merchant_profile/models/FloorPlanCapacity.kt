package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param default Default element capacity
 * @param max Max element capacity
 * @param min Min element capacity
 */
@Serializable
data class FloorPlanCapacity(
    /** Default element capacity */
    val default: Long? = null,
    /** Max element capacity */
    val max: Long? = null,
    /** Min element capacity */
    val min: Long? = null
)

