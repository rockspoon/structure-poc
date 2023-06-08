package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param salesTaxRate
 * @param serviceCharge
 */
@Serializable
data class DineInServices(
    val salesTaxRate: Long? = null,
    val serviceCharge: ServiceCharge? = null
)

