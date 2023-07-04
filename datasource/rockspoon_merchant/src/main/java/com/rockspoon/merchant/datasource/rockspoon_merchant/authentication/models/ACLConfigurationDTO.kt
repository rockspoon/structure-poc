package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param active
 * @param code
 * @param createdAt
 * @param createdBy
 * @param description
 * @param featureVersions
 * @param id
 * @param isDeleted
 * @param name
 * @param permissionVersions
 * @param productVersions
 * @param updatedAt
 * @param updatedBy
 * @param version
 */
@Serializable
data class ACLConfigurationDTO(
    val active: Boolean? = null,
    val code: String? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val featureVersions: List<FeatureVersionDTO>? = null,
    val id: String? = null,
    val isDeleted: Boolean? = null,
    val name: String? = null,
    val permissionVersions: List<PermissionVersionDTO>? = null,
    val productVersions: List<ProductVersionDTO>? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val version: String? = null
)

