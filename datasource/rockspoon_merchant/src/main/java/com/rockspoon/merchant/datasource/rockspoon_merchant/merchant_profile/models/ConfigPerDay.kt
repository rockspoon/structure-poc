package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable

/**
 * ConfigPerDay represents config per day for capacity
 *
 * @param minTableSize
 * @param maxTableSize
 * @param capacity
 * @param averageTimeInMinutes
 * @param dayOfWeek
 * @param timeFrom
 * @param timeTo
 */
@Serializable
data class ConfigPerDay(
    @Serializable(with = BigDecimalSerializer::class)
    val minTableSize: java.math.BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val maxTableSize: java.math.BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val capacity: java.math.BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val averageTimeInMinutes: java.math.BigDecimal? = null,
    val dayOfWeek: WeekDay? = null,
    val timeFrom: String? = null,
    val timeTo: String? = null
)

