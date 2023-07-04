package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param hourlySpecials
 * @param loyaltyProgram
 * @param welcomeOffer
 */
@Serializable
data class VenueCRM(
    val hourlySpecials: VenueCRMHourlySpecials? = null,
    val loyaltyProgram: VenueCRMLoyalty? = null,
    val welcomeOffer: VenueCRMOffer? = null
)

