package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param Address
 * @param CityStatePost
 * @param Country
 * @param Remarks
 */
@Serializable
data class GiactAddress(
    @SerialName("Address")
    val address: String? = null,
    @SerialName("CityStatePost")
    val cityStatePost: String? = null,
    @SerialName("Country")
    val country: String? = null,
    @SerialName("Remarks")
    val remarks: String? = null
)

