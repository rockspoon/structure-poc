package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models

import kotlinx.datetime.TimeZone
import kotlinx.serialization.Serializable

@Serializable
data class VenueAddressDto(
	val city: String,
	val country: String,
	val state: String,
	val address1: String,
	val address2: String?,
	val zipcode: String?,
	val timezone: TimeZone
)