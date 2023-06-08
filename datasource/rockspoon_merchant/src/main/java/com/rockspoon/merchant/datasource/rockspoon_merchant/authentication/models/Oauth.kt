package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param disabled
 * @param grants
 * @param loginMode
 * @param pin
 * @param redirectURI
 * @param secret
 * @param type
 */
@Serializable
data class Oauth(
    val disabled: Long? = null,
    val grants: List<String>? = null,
    val loginMode: String? = null,
    val pin: Map<String, EnabledForProduct>? = null,
    val redirectURI: String? = null,
    val secret: String? = null,
    val type: Long? = null
)

