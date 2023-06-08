package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Update business-entity's plan request object
 *
 * @param planId
 */
@Serializable
data class UpdateBusinessEntityPlanRequest(
    val planId: String? = null
)

