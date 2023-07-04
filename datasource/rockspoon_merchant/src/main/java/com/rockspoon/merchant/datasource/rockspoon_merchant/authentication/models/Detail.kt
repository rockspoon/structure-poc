package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param code
 * @param message
 */
@Serializable
data class Detail(
    val code: Long? = null,
    val message: String? = null
)

