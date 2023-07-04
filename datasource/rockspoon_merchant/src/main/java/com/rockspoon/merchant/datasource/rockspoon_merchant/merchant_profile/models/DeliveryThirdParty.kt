package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * DeliveryThirdParty represents delivery thirdParty model
 *
 * @param cutoffTime
 * @param fee
 * @param name
 * @param payCycle
 */
@Serializable
data class DeliveryThirdParty(
    val cutoffTime: Long? = null,
    val fee: Long? = null,
    val name: String? = null,
    val payCycle: DeliveryThirdPartyPayCycle? = null
)

