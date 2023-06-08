package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param websiteUrl */
@Serializable
data class WebsiteURLRequest(
    val websiteUrl: String? = null
)

