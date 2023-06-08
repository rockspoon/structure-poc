package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageResolutionDto(
	val url: String?,
	val width: Long,
	val height: Long
)
