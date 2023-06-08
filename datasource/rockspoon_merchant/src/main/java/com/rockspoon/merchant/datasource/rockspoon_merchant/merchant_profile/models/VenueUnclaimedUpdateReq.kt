package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param name
 * @param description
 * @param operatingEntity
 * @param address
 * @param marketingData
 */
@Serializable
data class VenueUnclaimedUpdateReq(
    val name: String? = null,
    val description: String? = null,
    val operatingEntity: OperatingEntityDTO? = null,
    val address: Address? = null,
    val marketingData: VenueMarketingData? = null
)

