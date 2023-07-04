package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param email
 * @param forUser;
 * @param id
 * @param name
 */
@Serializable
data class ShadowUserLoginRequest(
    val email: String? = null,
    @SerialName("for")
    val forUser: String? = null,
    val id: String? = null,
    val name: String? = null
)

