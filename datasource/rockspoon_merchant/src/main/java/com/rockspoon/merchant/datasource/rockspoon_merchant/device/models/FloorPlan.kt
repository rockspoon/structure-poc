package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Floorplan printer configuration
 *
 * @param ids ids of the floorPlans linked to this configuration.
 * @param divers
 * @param type floorPlan type.
 */
@Serializable
data class FloorPlan(
    /** ids of the floorPlans linked to this configuration. */
    val ids: List<String>? = null,
    val divers: Boolean? = null,
    /** floorPlan type. */
    val type: Topic? = null
)

