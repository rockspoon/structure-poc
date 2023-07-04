package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** @param roleID */
@Serializable
data class SwitchRoleRequest(
    @SerialName("RoleID")
    val roleID: String? = null
)

