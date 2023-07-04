package com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models

import kotlinx.serialization.Serializable

@Serializable
data class DropoffAddressDto(
	val city: String,
	val name: String,
	val state: String,
	val zipCode: String,
	val country: String,
	val address1: String,
	val id: String? = null,
	val region: String? = null,
	val address2: String? = null,
	val latitude: Double? = null,
	val longitude: Double? = null,
	val instructions: String? = null,
)