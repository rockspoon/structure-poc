package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class KitchenCardTypeDto(val value: String) {

	@SerialName("dine-in")
	DINE_IN("dine-in"),

	@SerialName("delivery")
	DELIVERY("delivery"),

	@SerialName("takeout")
	TAKEOUT("takeout"),

	@SerialName("curbside")
	CURBSIDE("curbside"),

	@SerialName("prepped-food")
	PREPPED_FOOD("prepped-food"),

	@SerialName("qsr")
	QUICK_SERVICE("qsr")
}