@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.CarInfoDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * OrderResponse represent an order
 *
 * @param attendance
 * @param orderId
 * @param shortId
 * @param type
 * @param domain
 * @param status
 * @param venueId
 * @param createdAt date format 2019-10-20T15:00:00Z
 * @param updatedAt date format 2019-10-20T15:00:00Z
 * @param scheduledFor date format 2019-10-20T15:00:00Z
 * @param preparationTime preparation time in seconds
 * @param pickupTime pickup time, format 2019-10-20T15:00:00Z
 * @param thirdPartyDelivery
 * @param comment
 * @param customers
 * @param address
 * @param floorPlanLocation
 * @param floorPlanLocations
 * @param checks
 * @param attendedBy
 * @param securityDepositIds
 * @param closedAt date format 2019-10-20T15:00:00Z
 * @param total
 * @param bags
 * @param numberOfItems
 * @param hasAlcoholicBeverage Flag to indicate whether the order includes
 *     alcoholic beverages
 * @param numberOfUnavailableItems
 * @param description field that contains all order items descriptions
 *     grouped by item name
 * @param needsAssistance
 * @param firedAt date format 2019-10-20T15:00:00Z
 * @param consumerArrivedAt consumer arrived at time, format
 *     2019-10-20T15:00:00Z
 * @param carInfoDto
 * @param consumerDocument
 * @param deliveredBy
 * @param reservationId
 * @param cancelledAt date format 2019-10-20T15:00:00Z
 * @param lockedToDevice
 * @param closeReason
 * @param leasingId
 * @param shippingId
 * @param invoiceURL
 * @param salesInfo
 * @param fulfilledWithoutFiringCount
 * @param workCycle
 */
@Serializable
data class OrderResponse(
    val attendance: List<AttendanceInfo>,
    val orderId: String,
    val shortId: String,
    val type: OrderTypeDto,
    val status: OrderStatus,
    /** date format 2019-10-20T15:00:00Z */
    val createdAt: Instant,
    val securityDepositIds: List<String>,
    /** field that contains all order items descriptions grouped by item name */
    val description: String,
    val domain: OrderDomain? = null,
    val venueId: String? = null,
    /** date format 2019-10-20T15:00:00Z */
    val updatedAt: Instant? = null,
    /** date format 2019-10-20T15:00:00Z */
    val scheduledFor: Instant? = null,
    /** preparation time in seconds */
    val preparationTime: String? = null,
    /** pickup time, format 2019-10-20T15:00:00Z */
    val pickupTime: Instant? = null,
    val thirdPartyDelivery: ThirdPartyDelivery? = null,
    val comment: String? = null,
    val customers: List<OrderCustomerResponse>? = null,
    val address: PatchCAPaymentInfoTips? = null,
    val floorPlanLocation: PatchCAPaymentInfoTips? = null,
    val floorPlanLocations: List<FloorPlanLocationResponse>? = null,
    val checks: List<GenericCheck>? = null,
    val attendedBy: String? = null,
    /** date format 2019-10-20T15:00:00Z */
    val closedAt: Instant? = null,
    val total: PriceDto? = null,
    val bags: List<BagResponse>? = null,
    val numberOfItems: String? = null,
    /** Flag to indicate whether the order includes alcoholic beverages */
    val hasAlcoholicBeverage: Boolean? = null,
    val numberOfUnavailableItems: String? = null,
    val needsAssistance: Boolean? = null,
    /** date format 2019-10-20T15:00:00Z */
    val firedAt: Instant? = null,
    /** consumer arrived at time, format 2019-10-20T15:00:00Z */
    val consumerArrivedAt: Instant? = null,
    val carInfoDto: CarInfoDto? = null,
    val consumerDocument: ConsumerDocumentResponse? = null,
    val deliveredBy: String? = null,
    val reservationId: String? = null,
    /** date format 2019-10-20T15:00:00Z */
    val cancelledAt: Instant? = null,
    val lockedToDevice: String? = null,
    val closeReason: String? = null,
    val leasingId: String? = null,
    val shippingId: String? = null,
    val invoiceURL: String? = null,
    val salesInfo: SalesInfoReponse? = null,
    val fulfilledWithoutFiringCount: BigDecimal? = null,
    val workCycle: WorkCycleDetailsResponse? = null
)

