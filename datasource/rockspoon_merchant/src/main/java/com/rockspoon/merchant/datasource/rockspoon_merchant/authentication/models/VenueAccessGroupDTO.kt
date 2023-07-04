package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param addedAt
 * @param id
 * @param removedAt
 */
@Serializable
data class VenueAccessGroupDTO(
    val addedAt: Instant? = null,
    val id: String? = null,
    val removedAt: Instant? = null
)

