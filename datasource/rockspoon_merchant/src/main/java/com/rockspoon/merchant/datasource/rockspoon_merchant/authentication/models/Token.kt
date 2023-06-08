package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param accessToken
 * @param expiresIn
 * @param refreshToken
 * @param tokenType
 */
@Serializable
data class Token(
    val accessToken: String,
    val expiresIn: Long,
    val refreshToken: String,
    val tokenType: String
)

