package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * Category Aggregation created by grouping roles by distinct categories
 *
 * @param name
 * @param roles
 */
@Serializable
data class Category(
    val name: String? = null,
    val roles: List<Role>? = null
)

