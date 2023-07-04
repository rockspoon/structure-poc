package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * VenueResponse represents venue response
 *
 * @param address
 * @param description
 * @param id
 * @param key
 * @param logo
 * @param name
 * @param code
 * @param tenantId
 * @param websites
 * @param type
 */
@Serializable
data class VenueResponse(
    val address: Address? = null,
    val description: String? = null,
    val id: String? = null,
    val key: kotlin.collections.Map<String, String>? = null,
    val logo: ImageDTO? = null,
    val name: String? = null,
    val code: String? = null,
    val tenantId: String? = null,
    val websites: List<Website>? = null,
    val type: VenueType? = null
)

