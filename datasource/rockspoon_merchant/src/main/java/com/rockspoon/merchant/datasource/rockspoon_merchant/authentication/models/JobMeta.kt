package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param agentId
 * @param bagLimit
 */
@Serializable
data class JobMeta(
    val agentId: String? = null,
    val bagLimit: Long? = null
)

