package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CustomModifiersTypeDto {
	@SerialName("default")
	DEFAULT,

	@SerialName("to-go")
	TOGO;
}
