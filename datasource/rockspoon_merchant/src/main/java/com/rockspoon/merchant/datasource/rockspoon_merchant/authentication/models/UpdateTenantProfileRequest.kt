package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param businessEntityId
 * @param venueId
 * @param venueName
 */
@Serializable
data class UpdateTenantProfileRequest(
    val address: Address? = null,
    val businessEntityId: String? = null,
    val venueId: String? = null,
    val venueName: String? = null
)

