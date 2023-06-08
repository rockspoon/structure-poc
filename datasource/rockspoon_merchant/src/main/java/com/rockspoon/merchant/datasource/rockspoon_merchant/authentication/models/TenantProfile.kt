package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param businessEntityId
 * @param venueID
 * @param venueName
 */
@Serializable
data class TenantProfile(
    val address: Address? = null,
    val businessEntityId: String? = null,
    val venueID: String? = null,
    val venueName: String? = null
)

