package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param description
 * @param logo
 * @param name
 * @param websites
 */
@Serializable
data class BrandDTO(
    val description: String? = null,
    val logo: ImageDTO? = null,
    val name: String? = null,
    val websites: List<Website>? = null
)

