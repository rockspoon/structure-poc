package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param env
 * @param extKey
 */
@Serializable
data class ExternalKey(
    val env: String? = null,
    val extKey: String? = null
)

