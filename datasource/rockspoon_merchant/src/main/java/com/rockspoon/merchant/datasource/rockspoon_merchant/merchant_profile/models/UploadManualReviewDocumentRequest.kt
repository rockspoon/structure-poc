package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param name
 * @param content
 */
@Serializable
data class UploadManualReviewDocumentRequest(
    val name: String? = null,
    val content: String? = null
)

