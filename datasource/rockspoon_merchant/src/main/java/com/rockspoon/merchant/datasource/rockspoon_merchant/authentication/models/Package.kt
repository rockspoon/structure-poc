package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param code
 * @param name
 * @param tags
 */
@Serializable
data class Package(
    val code: String? = null,
    val name: String? = null,
    val tags: List<String>? = null
)

