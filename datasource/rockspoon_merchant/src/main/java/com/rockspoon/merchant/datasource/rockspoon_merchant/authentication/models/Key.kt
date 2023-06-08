package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param extKeys
 * @param key
 */
@Serializable
data class Key(
    val extKeys: List<ExternalKey>? = null,
    val key: String? = null
)

