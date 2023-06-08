package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param name
 * @param products
 */
@Serializable
data class ServicePackageRequest(
    val name: String? = null,
    val products: List<ProductRequest>? = null
)

