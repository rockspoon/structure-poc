package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.serialization.Serializable

@Serializable
data class FloorPlanToggleType(
    val title: String,
    val type: String
)