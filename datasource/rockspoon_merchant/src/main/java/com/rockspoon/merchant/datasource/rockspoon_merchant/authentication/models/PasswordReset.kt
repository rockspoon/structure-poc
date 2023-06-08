package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param confirmation
 * @param password
 * @param token
 */
@Serializable
data class PasswordReset(
    val confirmation: String? = null,
    val password: String? = null,
    val token: String? = null
)

