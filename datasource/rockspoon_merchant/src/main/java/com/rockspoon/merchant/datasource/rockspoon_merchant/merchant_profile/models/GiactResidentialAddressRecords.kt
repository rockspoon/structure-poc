package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * GiactResidentialAddressRecords is lots of GiactAddressRecord
 *
 * @param giactAddressRecord
 */
@Serializable
data class GiactResidentialAddressRecords(
    @SerialName("GiactAddressRecord")
    val giactAddressRecord: List<GiactAddressRecord>? = null
)

