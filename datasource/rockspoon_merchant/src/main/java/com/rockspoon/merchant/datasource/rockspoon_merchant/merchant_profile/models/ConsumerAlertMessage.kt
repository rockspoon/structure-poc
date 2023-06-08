package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ConsumerAlertMessage represents
 *
 * @param code
 * @param description
 */
@Serializable
data class ConsumerAlertMessage(
    @SerialName("Code")
    val code: String? = null,
    @SerialName("Description")
    val description: String? = null
)

