package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class OrderHistoryEntryTypeDto(val value: String) {

	@SerialName("moved_to_overdue_balance")
	MOVED_TO_OVERDUE_BALANCE("moved_to_overdue_balance"),

	@SerialName("archived")
	ARCHIVED("archived"),

	@SerialName("unarchived")
	UNARCHIVED("unarchived"),

	@SerialName("closed")
	CLOSED("closed"),

	@SerialName("payment_link_sent")
	PAYMENT_LINK_SENT("payment_link_sent"),

	@SerialName("payment_link_opened")
	PAYMENT_LINK_OPENED("payment_link_opened"),

	@SerialName("payment_received")
	PAYMENT_RECEIVED("payment_received"),

	@SerialName("payment_declined")
	PAYMENT_DECLINED("payment_declined"),

	@SerialName("payment_refunded")
	PAYMENT_REFUNDED("payment_refunded")

}