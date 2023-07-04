package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param endDate
 * @param groupCode
 * @param id
 * @param startDate
 */
@Serializable
data class RoleDTO(
    val endDate: Instant? = null,
    val groupCode: String? = null,
    val id: String? = null,
    val startDate: Instant? = null
)

