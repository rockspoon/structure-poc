package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param access
 * @param continueUrl
 * @param email
 * @param firstName
 * @param isNewUser
 * @param lastName
 * @param mode
 */
@Serializable
data class SocialLoginResponse(
    val access: Token? = null,
    val continueUrl: String? = null,
    val email: String? = null,
    val firstName: String? = null,
    val isNewUser: Boolean? = null,
    val lastName: String? = null,
    val mode: String? = null
)

