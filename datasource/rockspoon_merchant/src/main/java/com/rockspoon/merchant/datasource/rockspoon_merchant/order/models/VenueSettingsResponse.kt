@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param isLightPOS
 * @param payOnPaper
 * @param splitItem
 * @param splitPayment
 * @param payByItem
 * @param payBySeat
 * @param bagByOrderTypes concerns bagging feature in POS
 * @param kitchenSettings
 * @param verifyCustomerDocumentByOrderTypes order types where customer
 *     identity should be verified
 * @param refundReturnedBags a percentage value that venue willing to
 *     compensate
 * @param extraFees
 * @param ordersView
 * @param covid
 * @param customFees
 * @param maxPaymentSplits
 * @param maxPayByItemPayers
 * @param maxItemSplits
 * @param freeDeliveryMinimumAmount
 * @param deliveryAveragePreparationTime
 * @param tipPercentages
 * @param receipts
 * @param digitalOrdering
 * @param defaultTipsSelected
 */
@Serializable
data class VenueSettingsResponse(
    val isLightPOS: Boolean? = null,
    val payOnPaper: Boolean? = null,
    val splitItem: Boolean? = null,
    val splitPayment: Boolean? = null,
    val payByItem: Boolean? = null,
    val payBySeat: Boolean? = null,
    /** concerns bagging feature in POS */
    val bagByOrderTypes: List<OrderTypeDto>? = null,
    val kitchenSettings: KitchenSettingsDto? = null,
    /** order types where customer identity should be verified */
    val verifyCustomerDocumentByOrderTypes: List<OrderTypeDto>? = null,
    /** a percentage value that venue willing to compensate */
    val refundReturnedBags: BigDecimal? = null,
    val extraFees: List<ExtraFeeResponse>? = null,
    val ordersView: OrdersView? = null,
    val covid: VenueCovidOptions? = null,
    val customFees: List<CustomFee>? = null,
    val maxPaymentSplits: BigDecimal? = null,
    val maxPayByItemPayers: BigDecimal? = null,
    val maxItemSplits: BigDecimal? = null,
    val freeDeliveryMinimumAmount: BigDecimal? = null,
    val deliveryAveragePreparationTime: BigDecimal? = null,
    val tipPercentages: List<BigDecimal>? = null,
    val receipts: VenueSettingsReceiptResponse? = null,
    val digitalOrdering: DigitalOrdering? = null,
    val defaultTipsSelected: BigDecimal? = null
)

