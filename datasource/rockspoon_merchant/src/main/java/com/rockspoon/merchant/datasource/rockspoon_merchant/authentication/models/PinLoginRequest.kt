package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param pin */
@Serializable
data class PinLoginRequest(
    val pin: String? = null
)

