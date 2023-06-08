package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param caption
 * @param imageId
 * @param index
 * @param isDefault
 * @param tags
 * @param title
 */
@Serializable
data class UpdateGalleryImage(
    val caption: String? = null,
    val imageId: String? = null,
    val index: Long? = null,
    val isDefault: Boolean? = null,
    val tags: List<String>? = null,
    val title: String? = null
)

