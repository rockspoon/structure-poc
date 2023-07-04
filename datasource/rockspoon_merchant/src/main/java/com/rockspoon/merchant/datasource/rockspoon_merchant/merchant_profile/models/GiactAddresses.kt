package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * GiactAddresses is an array
 *
 * @param GiactAddress
 */
@Serializable
data class GiactAddresses(
    @SerialName("giactAddress")
    val giactAddress: List<GiactAddress>? = null
)

