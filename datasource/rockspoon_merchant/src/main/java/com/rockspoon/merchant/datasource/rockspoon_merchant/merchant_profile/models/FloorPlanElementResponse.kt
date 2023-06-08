package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param capacity
 * @param dimensions
 * @param elementId ElementID should be passed if updating the element
 * @param elements Nested floor plan elements. E.g. bar area with nested
 *     bar seats.
 * @param name Element number
 * @param position
 * @param type type
 */
@Serializable
data class FloorPlanElementResponse(
    /** Element number */
    val name: String,
    val position: FloorPlanElementPositionResponse,
    /** type */
    val type: FloorPlanElementResponse.Type,
    val capacity: FloorPlanCapacity? = null,
    val dimensions: FloorPlanDimensions? = null,
    /** ElementID should be passed if updating the element */
    val elementId: String? = null,
    /** Nested floor plan elements. E.g. bar area with nested bar seats. */
    val elements: List<FloorPlanElementResponse>? = null
) {

    /** type */
    // Edited. There was a lot of errors.
    @Serializable
    enum class Type {

        @SerialName("round_bar_area")
        ROUND_BAR_AREA,

        @SerialName("square_bar_area")
        SQUARE_BAR_AREA,

        @SerialName("round_table")
        ROUND_TABLE,

        @SerialName("square_table")
        SQUARE_TABLE,

        @SerialName("round_standing_table")
        ROUND_STANDING_TABLE,

        @SerialName("square_standing_table")
        SQUARE_STANDING_TABLE,

        @SerialName("bar_seat")
        BAR_SEAT

    }

}

