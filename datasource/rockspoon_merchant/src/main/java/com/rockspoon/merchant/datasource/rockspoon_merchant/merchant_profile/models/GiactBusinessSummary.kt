package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param PotentialMatchAka
 * @param PotentialMatchDetails
 * @param PotentialMatchLevel
 */
@Serializable
data class GiactBusinessSummary(
    @SerialName("PotentialMatchAka")
    val potentialMatchAka: Boolean? = null,
    @SerialName("PotentialMatchDetails")
    val potentialMatchDetails: ArrayOfString? = null,
    @SerialName("PotentialMatchLevel")
    val potentialMatchLevel: String? = null
)

