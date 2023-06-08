package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param password
 * @param tenantId
 * @param username
 */
@Serializable
data class LoginRequest(
    val password: String? = null,
    val tenantId: String? = null,
    val username: String? = null
)

