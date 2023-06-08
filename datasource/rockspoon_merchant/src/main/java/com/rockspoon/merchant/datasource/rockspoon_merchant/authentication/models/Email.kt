package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param email
 * @param isDefault
 */
@Serializable
data class Email(
    val email: String? = null,
    val isDefault: Boolean? = null
)

