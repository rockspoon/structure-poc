package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param updated
 * @param deleted
 */
@Serializable
data class GetVenueChangesResponse(
    val updated: List<AdminGetVenuesResponse>? = null,
    val deleted: List<AdminGetVenuesResponse>? = null
)

