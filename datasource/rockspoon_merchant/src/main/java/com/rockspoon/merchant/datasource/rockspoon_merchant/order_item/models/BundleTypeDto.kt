package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BundleTypeDto {

	@SerialName("prix_fixe")
	PRIX_FIXE,

	@SerialName("multicategory_combo")
	MULTICATEGORY_COMBO,

	@SerialName("sushi")
	SUSHI,

	@SerialName("combo")
	COMBO,

	@SerialName("multiflavor_pizza")
	MULTIFLAVOR_PIZZA;
}
