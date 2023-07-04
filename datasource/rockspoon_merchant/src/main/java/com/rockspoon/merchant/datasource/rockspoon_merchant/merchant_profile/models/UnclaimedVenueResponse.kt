package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param marketingData */
@Serializable
data class UnclaimedVenueResponse(
    val marketingData: VenueMarketingData? = null,
    val address: Address? = null,
    val description: String? = null,
    val id: String? = null,
    val key: Map<String, String>? = null,
    val logo: ImageDTO? = null,
    val name: String? = null,
    val code: String? = null,
    val tenantId: String? = null,
    val websites: List<Website>? = null,
    val type: VenueType? = null
)

