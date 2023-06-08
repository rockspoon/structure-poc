package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param createdBy
 * @param id
 * @param key
 * @param tenantId
 * @param updatedAt
 * @param updatedBy
 * @param venueId
 */
@Serializable
data class APIKeyDTO(
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val id: String? = null,
    val key: String? = null,
    val tenantId: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val venueId: String? = null
)

