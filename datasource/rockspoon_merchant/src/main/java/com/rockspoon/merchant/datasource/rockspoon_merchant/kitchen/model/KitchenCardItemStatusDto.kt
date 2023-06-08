package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class KitchenCardItemStatusDto(val value: String) {
	@SerialName("fired")
	FIRED("fired"),

	@SerialName("in_progress")
	IN_PROGRESS("in_progress"),

	@SerialName("ready_for_delivery")
	READY_FOR_DELIVERY("ready_for_delivery"),

	@SerialName("ready_for_pickup")
	READY_FOR_PICK_UP("ready_for_pickup"),

	@SerialName("out_for_delivery")
	OUT_FOR_DELIVERY("out_for_delivery"),

	@SerialName("delivered")
	DELIVERED("delivered"),

	@SerialName("voided")
	VOIDED("voided"),

	@SerialName("canceled")
	CANCELED("canceled"),

	@SerialName("deleted")
	DELETED("deleted"),

	@SerialName("pending")
	PENDING("pending")
}