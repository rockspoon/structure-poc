package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param giactPhoneNumber */
@Serializable
data class GiactPhoneNumbers(
    @SerialName("GiactPhoneNumber")
    val giactPhoneNumber: List<GiactPhoneNumber>? = null
)

