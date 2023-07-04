package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param apis
 * @param createdAt
 * @param createdBy
 * @param description
 * @param id
 * @param isDisabled
 * @param name
 * @param publishedAt
 * @param readApis
 * @param updatedAt
 * @param updatedBy
 * @param version
 * @param writeApis
 */
@Serializable
data class PermissionVersionDTO(
    val apis: List<APIDTO>? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val id: String? = null,
    val isDisabled: Boolean? = null,
    val name: String? = null,
    val publishedAt: Instant? = null,
    val readApis: List<APIDTO>? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val version: String? = null,
    val writeApis: List<APIDTO>? = null
)

