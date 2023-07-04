package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param signed
 * @param url
 */
@Serializable
data class SignResponse(
    val signed: Boolean? = null,
    val url: String? = null
)

