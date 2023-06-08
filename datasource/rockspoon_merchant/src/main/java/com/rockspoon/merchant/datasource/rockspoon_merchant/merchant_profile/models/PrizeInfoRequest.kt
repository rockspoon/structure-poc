package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * holds the request information for referral tier with prize type
 *
 * @param additionalCashPrize
 * @param additionalFeeDiscount
 * @param additionalIncrement
 * @param cashPrizeAmount
 * @param feeDiscountAmount
 * @param residual
 * @param revenueAmount
 * @param installmentMap
 */
@Serializable
data class PrizeInfoRequest(
    val additionalCashPrize: Long? = null,
    val additionalFeeDiscount: Long? = null,
    val additionalIncrement: Long? = null,
    val cashPrizeAmount: Long? = null,
    val feeDiscountAmount: Long? = null,
    val residual: Double? = null,
    val revenueAmount: Long? = null,
    val installmentMap: InstallmentMap? = null
)

