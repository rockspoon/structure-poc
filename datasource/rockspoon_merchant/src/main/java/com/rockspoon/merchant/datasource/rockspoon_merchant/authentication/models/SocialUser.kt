package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param email
 * @param firstName
 * @param id
 * @param lastName
 * @param name
 */
@Serializable
data class SocialUser(
    val email: String? = null,
    @SerialName("first_name")
    val firstName: String? = null,
    val id: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    val name: String? = null
)

