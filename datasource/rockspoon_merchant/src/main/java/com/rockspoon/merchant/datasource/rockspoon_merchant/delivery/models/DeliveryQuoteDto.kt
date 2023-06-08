package com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models

data class DeliveryQuoteDto(
	val fee: Long? = null,
	val id: String? = null,
	val expires: String? = null,
	val pickupAt: String? = null,
	val currency: String? = null,
	val dropoffAt: String? = null,
	val createdAt: String? = null,
)