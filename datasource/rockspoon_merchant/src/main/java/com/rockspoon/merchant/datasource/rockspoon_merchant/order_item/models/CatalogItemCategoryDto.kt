package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CatalogItemCategoryDto {

	@SerialName("food")
	FOOD,
	@SerialName("alcoholic_beverage")
	ALCOHOLIC_BEV,
	@SerialName("non_alcoholic_beverage")
	NON_ALCOHOLIC_BEV;
}
