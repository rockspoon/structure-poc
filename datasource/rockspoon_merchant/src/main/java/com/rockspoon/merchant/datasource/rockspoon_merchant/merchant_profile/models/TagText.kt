package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param value
 * @param language
 */
@Serializable
data class TagText(
    val value: String? = null,
    val language: String? = null
)

