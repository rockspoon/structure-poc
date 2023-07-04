package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param createdAt
 * @param createdBy
 * @param id
 * @param name
 * @param updatedAt
 * @param updatedBy
 * @param vmwareID
 */
@Serializable
data class TagDTO(
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val id: String? = null,
    val name: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val vmwareID: String? = null
)

