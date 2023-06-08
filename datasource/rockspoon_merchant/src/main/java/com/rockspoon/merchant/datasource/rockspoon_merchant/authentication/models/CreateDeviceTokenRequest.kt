package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/** @param tenantId */
@Serializable
data class CreateDeviceTokenRequest(
    val tenantId: String? = null
)

