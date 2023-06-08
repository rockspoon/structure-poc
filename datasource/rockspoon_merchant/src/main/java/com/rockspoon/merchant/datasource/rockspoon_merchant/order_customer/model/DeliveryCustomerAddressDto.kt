package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryCustomerAddressDto(
	val id: String?,
	val city: String,
	val country: String,
	val state: String,
	val address1: String,
	val address2: String?,
	val longitude: Double?,
	val latitude: Double?,
	val region: String?,
	val zipcode: String?,
	val instructions: String?
)
