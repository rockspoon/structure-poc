package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param basisPoints Each basis point is 0.1% of revenue */
@Serializable
data class BasisPointsInfo(
    /** Each basis point is 0.1% of revenue */
    val basisPoints: Long? = null
)

