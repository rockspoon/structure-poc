package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param tenantID */
@Serializable
data class SwitchContextRequest(
    @SerialName("TenantID")
    val tenantID: String? = null
)

