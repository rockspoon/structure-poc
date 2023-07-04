package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param code
 * @param packages
 */
@Serializable
data class ProductRequest(
    val code: String? = null,
    val packages: List<String>? = null
)

