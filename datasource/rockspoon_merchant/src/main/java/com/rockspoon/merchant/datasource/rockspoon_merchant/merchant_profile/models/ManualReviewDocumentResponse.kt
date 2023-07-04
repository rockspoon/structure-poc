package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param name
 * @param size
 * @param createdAt
 */
@Serializable
data class ManualReviewDocumentResponse(
    val id: String? = null,
    val name: String? = null,
    val size: Long? = null,
    val createdAt: Instant? = null
)

