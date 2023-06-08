package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param permissionId
 * @param type
 */
@Serializable
data class RolePermissionDTO(
    val permissionId: String? = null,
    val type: RolePermissionType? = null
)

