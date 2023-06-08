@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * contains time information (hours, minutes and seconds)
 *
 * @param hour
 * @param minute
 * @param second
 */
@Serializable
data class TimeRequest(
    val hour: BigDecimal,
    val minute: BigDecimal,
    val second: BigDecimal
)

