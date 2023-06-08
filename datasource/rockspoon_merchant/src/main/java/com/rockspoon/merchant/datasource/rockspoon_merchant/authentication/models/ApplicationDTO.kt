package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param description
 * @param id
 * @param keys
 * @param product
 * @param ttl
 */
@Serializable
data class ApplicationDTO(
    val description: String? = null,
    val id: String? = null,
    val keys: List<Key>? = null,
    val product: String? = null,
    val ttl: Long? = null
)

