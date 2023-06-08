package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param parking */
@Serializable
data class AmenitiesDTO(
    val parking: List<VenueParkingDTO>? = null
)

