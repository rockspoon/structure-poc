package com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeliveryResponseDto(
	val fee: Long,
	val id: String,
	val quoteId: String,
	val source: String,
	val status: Status,
	val currency: String,
	val serviceFee: Long,
	val internalId: String,
	val createdAt: Instant,
	val updatedAt: Instant,
	val paymentAmount: Long,
	val pickup: Information,
	val dropoff: Information,
	val deliveryType: String,
	val statusHistory: List<History>,
	val tip: Long? = null,
	val courier: Courier? = null,
	val orderValue: Long? = null,
	@SerialName("burq_status")
	val burqStatus: String? = null,
	val signature: String? = null,
	val lastPosition: Position? = null,
	val cancellationReason: String? = null,
	val proofOfDelivery: List<String>? = null,
) {
	@Serializable
	enum class Status(val value: String) {
		@SerialName("Pending")
		Pending("Pending"),

		@SerialName("Created")
		Created("Created"),

		@SerialName("FindingDriver")
		FindingDriver("FindingDriver"),

		@SerialName("DriverOnTheWay")
		DriverOnTheWay("driverOnTheWay"),

		@SerialName("DriverArrived")
		DriverArrived("DriverArrived"),

		@SerialName("DeliveryInProgress")
		DeliveryInProgress("DeliveryInProgress"),

		@SerialName("Delivered")
		Delivered("Delivered"),

		@SerialName("Canceled")
		Canceled("Canceled"),
	}

	@Serializable
	data class Courier(
		val img: String? = null,
		val name: String? = null,
		val vehicle: String? = null,
		val phoneNumber: String? = null,
		val vehicleType: String? = null,
	)

	@Serializable
	data class Position(
		val type: String? = null,
		val date: Instant? = null,
		val coordinates: List<Long>? = null,
	)

	@Serializable
	data class Information(
		val at: String? = null,
		val eta: Instant? = null,
		val name: String? = null,
		val unit: String? = null,
		val notes: String? = null,
		val address: String? = null,
		val phoneNumber: String? = null,
	)

	@Serializable
	data class History(
		val time: Instant,
		val status: Status,
	)
}
