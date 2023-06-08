package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param createdBy
 * @param description
 * @param id
 * @param isDisabled
 * @param name
 * @param permissions
 * @param publishedAt
 * @param updatedAt
 * @param updatedBy
 * @param version
 */
@Serializable
data class FeatureVersionDTO(
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val id: String? = null,
    val isDisabled: Boolean? = null,
    val name: String? = null,
    val permissions: List<PermissionDTO>? = null,
    val publishedAt: Instant? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val version: String? = null
)

