package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemTaxRuleDto {

	@SerialName("default")
	DEFAULT,

	@SerialName("tax-free")
	TAX_FREE;

}
