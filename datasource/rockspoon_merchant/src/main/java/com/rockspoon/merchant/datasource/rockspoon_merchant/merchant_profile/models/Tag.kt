package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param value
 * @param text
 */
@Serializable
data class Tag(
    val value: String? = null,
    val text: TagText? = null
)

