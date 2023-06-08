package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param blog
 * @param facebook
 * @param instagram
 * @param twitter
 * @param youtube
 */
@Serializable
data class WebsiteLinks(
    val blog: String? = null,
    val facebook: String? = null,
    val instagram: String? = null,
    val twitter: String? = null,
    val youtube: String? = null
)

