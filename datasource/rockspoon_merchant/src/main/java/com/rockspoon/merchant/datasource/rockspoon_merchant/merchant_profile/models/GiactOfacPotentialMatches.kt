package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param OfacListData */
@Serializable
data class GiactOfacPotentialMatches(
    @SerialName("OfacListData")
    val ofacListData: List<OfacListData>? = null
)

