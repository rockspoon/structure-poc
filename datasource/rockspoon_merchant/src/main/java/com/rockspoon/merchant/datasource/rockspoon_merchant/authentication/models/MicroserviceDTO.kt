package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param apis
 * @param createdAt
 * @param createdBy
 * @param id
 * @param lastUpdated
 * @param name
 * @param repo
 * @param updatedAt
 * @param updatedBy
 */
@Serializable
data class MicroserviceDTO(
    val apis: List<APIDTO>? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val id: String? = null,
    val lastUpdated: Instant? = null,
    val name: String? = null,
    val repo: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null
)

