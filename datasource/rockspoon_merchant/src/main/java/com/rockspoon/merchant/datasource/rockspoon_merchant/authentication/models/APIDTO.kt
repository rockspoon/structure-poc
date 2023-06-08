package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param createdBy
 * @param id
 * @param isPinWhitelisted
 * @param isPublic
 * @param method
 * @param path
 * @param service
 * @param updatedAt
 * @param updatedBy
 * @param version
 */
@Serializable
data class APIDTO(
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val id: String? = null,
    val isPinWhitelisted: Boolean? = null,
    val isPublic: Boolean? = null,
    val method: String? = null,
    val path: String? = null,
    val service: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val version: String? = null
)

