package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * RoleResp represents a role attribution to a profile
 *
 * @param current
 * @param endDate
 * @param id
 * @param name
 * @param packages
 * @param startDate
 */
@Serializable
data class RoleResp(
    val current: Boolean? = null,
    val endDate: Instant? = null,
    val id: String? = null,
    val name: String? = null,
    val packages: List<String>? = null,
    val startDate: Instant? = null
)

