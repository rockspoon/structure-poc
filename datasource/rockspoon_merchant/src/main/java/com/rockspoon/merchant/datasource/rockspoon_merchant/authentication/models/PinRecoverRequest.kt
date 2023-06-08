package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param client
 * @param pin
 */
@Serializable
data class PinRecoverRequest(
    val client: ClientType? = null,
    val pin: String? = null
)

