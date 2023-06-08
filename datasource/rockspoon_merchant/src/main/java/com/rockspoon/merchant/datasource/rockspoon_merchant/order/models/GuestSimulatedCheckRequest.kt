@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param subtotal
 * @param totalExemptSubtotal
 * @param orderType Default value is \"dine-in\"
 * @param orderId
 * @param venueId
 */
@Serializable
data class GuestSimulatedCheckRequest(
    val subtotal: BigDecimal,
    val totalExemptSubtotal: BigDecimal? = null,
    /** Default value is \"dine-in\" */
    val orderType: OrderTypeDto? = null,
    val orderId: String? = null,
    val venueId: String? = null
)

