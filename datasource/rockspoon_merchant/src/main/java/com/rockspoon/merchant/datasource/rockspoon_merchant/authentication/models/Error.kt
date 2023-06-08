package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param codes
 * @param details
 */
@Serializable
data class Error(
    val codes: List<Long>? = null,
    val details: List<Detail>? = null
)

