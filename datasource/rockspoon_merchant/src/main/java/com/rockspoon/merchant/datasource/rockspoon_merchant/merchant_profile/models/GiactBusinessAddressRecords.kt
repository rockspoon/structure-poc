package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * GiactBusinessAddressRecords is lots of addresses
 *
 * @param GiactAddressRecord
 */
@Serializable
data class GiactBusinessAddressRecords(
    @SerialName("GiactAddressRecord")
    val giactAddressRecord: List<GiactAddressRecord>? = null
)

