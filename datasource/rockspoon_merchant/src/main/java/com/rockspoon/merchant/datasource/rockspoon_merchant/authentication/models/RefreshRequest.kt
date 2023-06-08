package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param refreshToken */
@Serializable
data class RefreshRequest(
    val refreshToken: String? = null
)

