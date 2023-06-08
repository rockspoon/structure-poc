package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param accessToken
 * @param expiresIn
 * @param profile
 * @param refreshToken
 * @param tokenType
 * @param webVersion
 */
@Serializable
data class SwitchContextTokenWithProfile(
    val accessToken: String? = null,
    val expiresIn: Long? = null,
    val profile: UserProfileInfoResponse? = null,
    val refreshToken: String? = null,
    val tokenType: String? = null,
    val webVersion: String? = null
)

