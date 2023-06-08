package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param fee
 * @param maximumDeliveryTimeInMinutes
 * @param minimumDeliveryTimeInMinutes
 * @param orderMinimumAmount
 * @param range
 * @param thirdParties
 */
@Serializable
data class DeliveryServicesRequest(
    val fee: Fee? = null,
    val maximumDeliveryTimeInMinutes: Long? = null,
    val minimumDeliveryTimeInMinutes: Long? = null,
    val orderMinimumAmount: Long? = null,
    val range: ServiceRange? = null,
    val thirdParties: List<DeliveryThirdParty>? = null
)

