@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * response for get occupancy request, float64 represents percentage values
 *
 * @param tables
 * @param seats
 */
@Serializable
data class OccupancyResponse(
    val tables: BigDecimal? = null,
    val seats: BigDecimal? = null
)

