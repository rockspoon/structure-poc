package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param expiresAt
 * @param id
 * @param tenantId
 * @param token
 */
@Serializable
data class DeviceTokenDTO(
    val createdAt: Instant? = null,
    val expiresAt: Instant? = null,
    val id: String? = null,
    val tenantId: String? = null,
    val token: String? = null
)

