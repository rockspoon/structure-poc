package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DineInOrderItemStatusDto {
	@SerialName("pending")
	PENDING,
	@SerialName("fired")
	FIRED,
	@SerialName("deleted")
	DELETED,
	@SerialName("pending_cancel")
	PENDING_CANCEL,
	@SerialName("pending_void")
	PENDING_VOID,
	@SerialName("canceled")
	CANCELED,
	@SerialName("voided")
	VOIDED,
	@SerialName("in_progress")
	IN_PROGRESS,
	@SerialName("ready_for_delivery")
	READY_FOR_DELIVERY,
	@SerialName("out_for_delivery")
	OUT_FOR_DELIVERY,
	@SerialName("delivered")
	DELIVERED,
	@SerialName("fulfilled_without_firing")
	FULFILLED_WITHOUT_FIRING;
}