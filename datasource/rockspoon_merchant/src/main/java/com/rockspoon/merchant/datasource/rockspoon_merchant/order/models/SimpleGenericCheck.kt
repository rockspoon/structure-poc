@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param entries
 * @param grossTotal
 * @param netTotal
 * @param currency
 */
@Serializable
data class SimpleGenericCheck(
    val entries: List<SimpleOrderCheckEntry>? = null,
    val grossTotal: BigDecimal? = null,
    val netTotal: BigDecimal? = null,
    val currency: CurrencyType? = null
)

