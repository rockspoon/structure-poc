package com.rockspoon.merchant.datasource.rockspoon_merchant.order_settings.model

import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.KitchenSettingsDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.OrderTypeDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.VenueSettingsReceiptDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersViewSettingsDto(
	@SerialName("payOnPaper")
	val isPayOnPaperAvailable: Boolean,
	val maxPaymentSplits: Int,
	val maxPayByItemPayers: Int,
	val maxItemSplits: Int,
	@SerialName("splitItem")
	val isSplitItemAvailable: Boolean,
	@SerialName("payByItem")
	val isPayByItemAvailable: Boolean,
	@SerialName("splitPayment")
	val isSplitPaymentAvailable: Boolean,
	val tipPercentages: List<Int>,
	val receipts: VenueSettingsReceiptDto,
	@SerialName("payByCheck")
	val isPayByCheckAvailable: Boolean,
	@SerialName("payBySeat")
	val isPayBySeatAvailable: Boolean,
	val defaultTipsSelected: Int? = null,
	val freeDeliveryMinimumAmount: Int? = null,
	val verifyCustomerDocumentByOrderTypes: List<OrderTypeDto>? = null,
	val ordersView: OrdersViewDto? = null,
	@SerialName("kitchenSettings")
	val ordersKitchenSettings: KitchenSettingsDto? = null,
	val bagByOrderTypes: List<OrderTypeDto>? = null
)