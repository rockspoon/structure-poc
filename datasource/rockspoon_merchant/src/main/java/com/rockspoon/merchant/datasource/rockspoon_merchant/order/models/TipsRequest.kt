@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * Tips request structure
 *
 * @param type
 * @param absolute Tips absolute value in cents
 * @param percentage Tips float percentage
 */
@Serializable
data class TipsRequest(
    val type: AmountType? = null,
    /** Tips absolute value in cents */
    val absolute: BigDecimal? = null,
    /** Tips float percentage */
    val percentage: BigDecimal? = null
)

