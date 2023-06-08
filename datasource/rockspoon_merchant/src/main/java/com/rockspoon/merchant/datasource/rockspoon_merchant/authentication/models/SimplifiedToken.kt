package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param token */
@Serializable
data class SimplifiedToken(
    val token: String? = null
)

