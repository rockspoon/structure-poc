package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param forUser
 * @param userId
 */
@Serializable
data class PayByLinkLoginLegacyRequest(
    @SerialName("for")
    val forUser: String? = null,
    val userId: String? = null
)

