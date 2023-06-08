package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.serialization.Serializable

/**
 * @param availableAmounts
 * @param allowCustomAmount
 * @param maximumCustomAmount
 * @param minimumCustomAmount
 * @param enabled
 */
@Serializable
data class GiftCardOptionsResponse(
    val availableAmounts: List<PriceDto>? = null,
    val allowCustomAmount: Boolean? = null,
    val maximumCustomAmount: PriceDto? = null,
    val minimumCustomAmount: PriceDto? = null,
    val enabled: Boolean? = null
)

