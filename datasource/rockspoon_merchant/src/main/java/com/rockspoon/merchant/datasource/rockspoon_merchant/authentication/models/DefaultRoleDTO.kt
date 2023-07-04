package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param code
 * @param createdAt
 * @param createdBy
 * @param description
 * @param id
 * @param name
 * @param updatedAt
 * @param updatedBy
 * @param versions
 */
@Serializable
data class DefaultRoleDTO(
    val code: String? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val id: String? = null,
    val name: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val versions: List<DefaultRoleVersionDTO>? = null
)

