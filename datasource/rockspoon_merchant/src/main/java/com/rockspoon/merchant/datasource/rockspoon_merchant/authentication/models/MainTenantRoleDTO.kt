package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param job
 * @param jobMeta
 * @param mainTenantRoleID
 */
@Serializable
data class MainTenantRoleDTO(
    val job: MainTenantJob? = null,
    val jobMeta: JobMeta? = null,
    val mainTenantRoleID: String? = null
)

