package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * GalleryImageResponse represents venue image response at swagger
 *
 * @param caption
 * @param image
 * @param index
 * @param isDefault
 * @param tags
 * @param title
 */
@Serializable
data class GalleryImageResponse(
    val caption: String? = null,
    val image: ImageDTO? = null,
    val index: Long? = null,
    val isDefault: Boolean? = null,
    val tags: List<String>? = null,
    val title: String? = null
)

