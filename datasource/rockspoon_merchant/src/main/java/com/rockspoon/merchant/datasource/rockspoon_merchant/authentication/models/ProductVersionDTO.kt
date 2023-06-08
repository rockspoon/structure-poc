package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param createdBy
 * @param description
 * @param featureVersions
 * @param features
 * @param id
 * @param isDisabled
 * @param name
 * @param productCode
 * @param publishedAt
 * @param roles
 * @param updatedAt
 * @param updatedBy
 * @param version
 */
@Serializable
data class ProductVersionDTO(
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val featureVersions: List<FeatureVersionConfig>? = null,
    val features: List<FeatureDTO>? = null,
    val id: String? = null,
    val isDisabled: Boolean? = null,
    val name: String? = null,
    val productCode: String? = null,
    val publishedAt: Instant? = null,
    val roles: List<DefaultRoleDTO>? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val version: String? = null
)

