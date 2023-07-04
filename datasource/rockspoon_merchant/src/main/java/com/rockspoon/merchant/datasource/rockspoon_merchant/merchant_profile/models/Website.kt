package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Websites represents website model
 *
 * @param type
 * @param url
 */
@Serializable
data class Website(
    val type: String? = null,
    val url: String? = null
)

