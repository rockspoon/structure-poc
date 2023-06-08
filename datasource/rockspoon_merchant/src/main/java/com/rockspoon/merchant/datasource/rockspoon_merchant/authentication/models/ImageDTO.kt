package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * nolint
 *
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

