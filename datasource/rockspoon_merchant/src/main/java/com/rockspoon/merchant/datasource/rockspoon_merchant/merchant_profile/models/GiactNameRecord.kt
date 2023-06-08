package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param businessName
 * @param businessType
 */
@Serializable
data class GiactNameRecord(
    @SerialName("BusinessName")
    val businessName: String? = null,
    @SerialName("BusinessType")
    val businessType: String? = null
)

