@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param id
 * @param thirdPartyDeliveryId
 * @param name
 * @param chargeType
 * @param chargeValue
 * @param payCycleType
 * @param orderTypes default - OrderTypeDelivery, OrderTypeTakeout
 */
@Serializable
data class ThirdPartyDeliveryResponse(
    val id: String? = null,
    val thirdPartyDeliveryId: String? = null,
    val name: String? = null,
    val chargeType: AmountType? = null,
    val chargeValue: BigDecimal? = null,
    val payCycleType: PayCycleType? = null,
    /** default - OrderTypeDelivery, OrderTypeTakeout */
    val orderTypes: List<OrderTypeDto>? = null
)

