@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param name
 * @param percentage
 * @param grossPrice
 * @param netPrice
 * @param description
 */
@Serializable
data class SimpleOrderCheckEntry(
    val name: String? = null,
    val percentage: BigDecimal? = null,
    val grossPrice: BigDecimal? = null,
    val netPrice: BigDecimal? = null,
    val description: String? = null
)

