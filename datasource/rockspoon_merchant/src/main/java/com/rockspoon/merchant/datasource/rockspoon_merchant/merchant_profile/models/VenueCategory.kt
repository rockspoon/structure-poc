package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param name
 * @param createdAt
 * @param updatedAt
 */
@Serializable
data class VenueCategory(
    val id: String? = null,
    val name: String? = null,
    val createdAt: Instant? = null,
    val updatedAt: Instant? = null
)

