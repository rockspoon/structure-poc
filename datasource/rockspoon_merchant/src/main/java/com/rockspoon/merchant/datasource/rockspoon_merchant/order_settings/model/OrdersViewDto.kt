package com.rockspoon.merchant.datasource.rockspoon_merchant.order_settings.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersViewDto(
	@SerialName("previewTime")
	val previewTimeInSeconds: Long? = null,
	@SerialName("postviewTime")
	val postViewTimeInSeconds: Long? = null
)