package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ArrayOfNameRecords is a an array of name records
 *
 * @param giactNameRecord
 */
@Serializable
data class ArrayOfNameRecords(
    @SerialName("GiactNameRecord")
    val giactNameRecord: List<GiactNameRecord>? = null
)

