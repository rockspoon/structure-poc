package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param description
 * @param mainTenantId
 * @param name
 * @param operatingEntity
 * @param marketingData
 * @param products this field is only for v1, should be removed in v2
 * @param type
 */
@Serializable
data class VenueRequest(
    val address: Address? = null,
    val description: String? = null,
    val mainTenantId: String? = null,
    val name: String? = null,
    val operatingEntity: OperatingEntityDTO? = null,
    val marketingData: VenueMarketingData? = null,
    /** this field is only for v1, should be removed in v2 */
    val products: List<Product>? = null,
    val type: VenueType? = null
)

