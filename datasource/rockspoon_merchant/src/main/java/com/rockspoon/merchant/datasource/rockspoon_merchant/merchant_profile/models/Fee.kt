package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param type
 * @param value
 */
@Serializable
data class Fee(
    val type: FeeType? = null,
    val value: Long? = null
)

