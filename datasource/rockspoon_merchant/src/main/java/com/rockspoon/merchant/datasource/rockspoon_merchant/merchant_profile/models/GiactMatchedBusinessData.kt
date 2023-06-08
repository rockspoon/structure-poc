package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param BusinessDataRecord */
@Serializable
data class GiactMatchedBusinessData(
    @SerialName("BusinessDataRecord")
    val businessDataRecord: List<BusinessDataRecord>? = null
)

