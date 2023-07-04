package com.rockspoon.merchant.datasource.rockspoon_merchant.venue

import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.ItemPhotoDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.VenueAddressDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VenueDto(
	val id: String,
	val apiKey: String,
	val name: String,
	val address: VenueAddressDto,
	val logo: ItemPhotoDto?,
	@SerialName("code")
	val venueCode: String?
)