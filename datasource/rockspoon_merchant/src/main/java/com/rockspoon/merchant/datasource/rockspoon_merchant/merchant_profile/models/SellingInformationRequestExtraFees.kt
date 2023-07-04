package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param amount
 * @param beforeSalesTax
 * @param description
 * @param name
 * @param percentage
 * @param serviceType
 */
@Serializable
data class SellingInformationRequestExtraFees(
    val amount: Int? = null,
    val beforeSalesTax: Boolean? = null,
    val description: String? = null,
    val name: String? = null,
    val percentage: Double? = null,
    val serviceType: AvailableSalesOption? = null
)

