package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param id
 * @param name
 */
@Serializable
data class PropertyType(
    val id: String? = null,
    val name: String? = null
)

