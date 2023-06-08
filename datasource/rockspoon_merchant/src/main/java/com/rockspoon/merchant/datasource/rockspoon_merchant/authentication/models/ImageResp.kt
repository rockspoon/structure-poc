package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * ImageResp contains links to all resolutions for an image
 *
 * @param hiResolution
 * @param loResolution
 * @param noResolution
 * @param type
 */
@Serializable
data class ImageResp(
    val hiResolution: Resolution? = null,
    val loResolution: Resolution? = null,
    val noResolution: Resolution? = null,
    val type: String? = null
)

