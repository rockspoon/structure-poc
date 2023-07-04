package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param roleID
 * @param tenantID
 */
@Serializable
data class SwitchRoleForTenantRequest(
    @SerialName("RoleID")
    val roleID: String? = null,
    @SerialName("TenantID")
    val tenantID: String? = null
)

