package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param height
 * @param url
 * @param width
 */
@Serializable
data class Resolution(
    val height: Long? = null,
    val url: String? = null,
    val width: Long? = null
)

