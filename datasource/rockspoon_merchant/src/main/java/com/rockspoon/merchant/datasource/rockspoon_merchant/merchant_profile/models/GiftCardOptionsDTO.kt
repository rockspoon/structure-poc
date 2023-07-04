package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param availableAmounts This field is required if the restaurant does
 *     not allow custom amounts.
 * @param allowCustomAmount
 * @param maximumCustomAmount This field is required if the restaurant
 *     allow custom amounts.
 * @param minimumCustomAmount
 * @param enabled
 */
@Serializable
data class GiftCardOptionsDTO(
    val enabled: Boolean,
    /** This field is required if the restaurant does not allow custom amounts. */
    val availableAmounts: List<Long>? = null,
    val allowCustomAmount: Boolean? = null,
    /** This field is required if the restaurant allow custom amounts. */
    val maximumCustomAmount: Long? = null,
    val minimumCustomAmount: Long? = null
)

