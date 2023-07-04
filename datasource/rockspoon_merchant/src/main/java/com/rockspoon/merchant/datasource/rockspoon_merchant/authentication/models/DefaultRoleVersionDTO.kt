package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param UpdatedAt
 * @param active
 * @param createdAt
 * @param createdBy
 * @param description
 * @param id
 * @param name
 * @param packages
 * @param permissions
 * @param updatedBy
 * @param version
 */
@Serializable
data class DefaultRoleVersionDTO(
    @SerialName("UpdatedAt")
    val updatedAt: Instant? = null,
    val active: Boolean? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val id: String? = null,
    val name: String? = null,
    val packages: List<Package>? = null,
    val permissions: List<RolePermissionDTO>? = null,
    val updatedBy: String? = null,
    val version: String? = null
)

