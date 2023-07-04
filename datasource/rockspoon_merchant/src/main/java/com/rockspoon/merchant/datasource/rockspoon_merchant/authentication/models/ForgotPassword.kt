package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * ForgotPassword model
 *
 * @param client
 * @param phone
 * @param username
 */
@Serializable
data class ForgotPassword(
    val client: ClientType? = null,
    val phone: String? = null,
    val username: String? = null
)

