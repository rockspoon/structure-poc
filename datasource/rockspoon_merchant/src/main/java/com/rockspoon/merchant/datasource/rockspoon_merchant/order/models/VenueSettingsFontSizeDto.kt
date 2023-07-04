@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param receipt
 * @param bag
 * @param kds
 * @param item
 */
@Serializable
data class VenueSettingsFontSizeDto(
    val receipt: BigDecimal? = null,
    val bag: BigDecimal? = null,
    val kds: BigDecimal? = null,
    val item: BigDecimal? = null
)

