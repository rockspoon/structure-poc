package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param posReplacement */
@Serializable
data class POSReplacementRequest(
    val posReplacement: String
)

