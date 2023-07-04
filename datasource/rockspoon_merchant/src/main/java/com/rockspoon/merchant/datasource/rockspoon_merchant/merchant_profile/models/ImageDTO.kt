package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param contentType
 * @param id
 * @param resolutions
 */
@Serializable
data class ImageDTO(
    val contentType: String? = null,
    val id: String? = null,
    val resolutions: Resolutions? = null
)

