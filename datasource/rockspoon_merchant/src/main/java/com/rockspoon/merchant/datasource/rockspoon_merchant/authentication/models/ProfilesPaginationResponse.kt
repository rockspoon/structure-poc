package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param next
 * @param previous
 * @param results
 * @param total
 */
@Serializable
data class ProfilesPaginationResponse(
    val next: String? = null,
    val previous: String? = null,
    val results: List<ProfileDTO>? = null,
    val total: Long? = null
)

