package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import kotlinx.serialization.Serializable

@Serializable
data class OrderImageDto(
	val hiResolution: ImageResolutionDto?,
	val loResolution: ImageResolutionDto?,
	val noResolution: ImageResolutionDto?
)
