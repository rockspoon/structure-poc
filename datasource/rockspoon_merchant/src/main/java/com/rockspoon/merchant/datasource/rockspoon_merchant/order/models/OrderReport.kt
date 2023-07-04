@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * report containing all relevant information of a given order.
 *
 * @param createdAt date format 2019-10-20T15:00:00Z
 * @param closedAt date format 2019-10-20T15:00:00Z
 * @param categorySummary
 * @param voidedItems
 * @param compItems
 * @param employees
 * @param TableName
 * @param SeatsUsed
 * @param MaxOccupancy
 * @param moneySummary
 * @param paymentReport
 * @param checkSummary
 * @param orderType
 */
@Serializable
data class OrderReport(
    /** date format 2019-10-20T15:00:00Z */
    val createdAt: Instant? = null,
    /** date format 2019-10-20T15:00:00Z */
    val closedAt: Instant? = null,
    val categorySummary: Map<String, BigDecimal>? = null,
    val voidedItems: List<ItemInfo>? = null,
    val compItems: List<ItemInfo>? = null,
    val employees: List<OrderReportEmployees>? = null,
    @SerialName("TableName")
    val tableName: String? = null,
    @SerialName("SeatsUsed")
    val seatsUsed: BigDecimal? = null,
    @SerialName("MaxOccupancy")
    val maxOccupancy: BigDecimal? = null,
    val moneySummary: OrderMoneySummary? = null,
    val paymentReport: List<OrderPaymentReport>? = null,
    val checkSummary: OrderReportCheckSummary? = null,
    val orderType: OrderTypeDto? = null
)

