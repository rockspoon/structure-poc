package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * CategoryDTO represents DTO of Aggregation created by grouping roles by
 * distinct categories
 *
 * @param name
 * @param roles
 */
@Serializable
data class CategoryDTO(
    val name: String? = null,
    val roles: List<RoleDTO>? = null
)

