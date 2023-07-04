package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param _id
 * @param applications
 * @param categoryId
 * @param code
 * @param createdAt
 * @param createdBy
 * @param description
 * @param name
 * @param oauth
 * @param profile
 * @param tags
 * @param tenant
 * @param type
 * @param updatedAt
 * @param updatedBy
 * @param vmwareId
 */
@Serializable
data class TenantDTO(
    @SerialName("_id")
    val id: String? = null,
    val applications: List<ApplicationDTO>? = null,
    val categoryId: String? = null,
    val code: String? = null,
    val createdAt: Instant? = null,
    val createdBy: String? = null,
    val description: String? = null,
    val name: String? = null,
    val oauth: Oauth? = null,
    val profile: TenantProfile? = null,
    val tags: List<TagDTO>? = null,
    val tenant: TenantResume? = null,
    val type: String? = null,
    val updatedAt: Instant? = null,
    val updatedBy: String? = null,
    val vmwareId: Long? = null
)

