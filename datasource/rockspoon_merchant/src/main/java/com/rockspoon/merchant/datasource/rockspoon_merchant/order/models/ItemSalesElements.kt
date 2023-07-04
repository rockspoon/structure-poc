@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * element of the list of items sold by the restaurant ordered from most
 * sold to least sold.
 *
 * @param name
 * @param quantity
 * @param average
 * @param total
 */
@Serializable
data class ItemSalesElements(
    val name: String? = null,
    val quantity: String? = null,
    val average: BigDecimal? = null,
    val total: BigDecimal? = null
)

