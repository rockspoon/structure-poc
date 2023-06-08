package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param id
 * @param name
 * @param size
 * @param createdAt
 * @param downloadLink
 * @param linkExpirationDate
 */
@Serializable
data class GetManualReviewDocumentResponse(
    val id: String? = null,
    val name: String? = null,
    val size: Long? = null,
    val createdAt: Instant? = null,
    val downloadLink: String? = null,
    val linkExpirationDate: Instant? = null
)

