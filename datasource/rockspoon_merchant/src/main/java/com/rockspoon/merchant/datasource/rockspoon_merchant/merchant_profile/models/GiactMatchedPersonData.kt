package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param PersonDataRecord */
@Serializable
data class GiactMatchedPersonData(
    @SerialName("PersonDataRecord")
    val personDataRecord: List<GiactPersonDataRecord>? = null
)

