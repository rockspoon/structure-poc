package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param extraEmails */
@Serializable
data class ResendDeviceRequest(
    val extraEmails: List<String>? = null
)

