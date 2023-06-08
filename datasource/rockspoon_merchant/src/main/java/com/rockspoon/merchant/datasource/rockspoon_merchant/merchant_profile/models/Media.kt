package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Media represents media model
 *
 * @param media
 * @param url
 */
@Serializable
data class Media(
    val media: String? = null,
    val url: String? = null
)

