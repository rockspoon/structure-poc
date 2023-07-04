package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BeverageCategoryDto {
	@SerialName("water")
	WATER,
	@SerialName("juice")
	JUICE,
	@SerialName("smoothie")
	SMOOTHIE,
	@SerialName("soda")
	SODA,
	@SerialName("coffee")
	COFFEE,
	@SerialName("tea")
	TEA,
	@SerialName("beer")
	BEER,
	@SerialName("wine")
	WINE,
	@SerialName("sake")
	SAKE,
	@SerialName("spirits")
	SPIRITS,
	@SerialName("corkage")
	CORKAGE,
	@SerialName("cocktails")
	COCKTAILS,
	@SerialName("other")
	OTHER,
	@SerialName("none")
	NONE;
}
