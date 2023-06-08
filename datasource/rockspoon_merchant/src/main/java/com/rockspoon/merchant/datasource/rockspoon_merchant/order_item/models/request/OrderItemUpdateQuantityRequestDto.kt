package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BeverageCategoryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.CatalogItemCategoryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.OrderCustomerAllergenDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemUpdateQuantityRequestDto(
	val course: Int?,
	val servingOption: ServingOptionDto?,
	val numberOfPlates: Int?,
	val customerIds: List<String>?,
	val sizeId: String?,
	val metadata: ItemMetaDataRequestDto?,
	val routings: List<String>?,
	val category: CatalogItemCategoryDto?,
	val subcategory: BeverageCategoryDto?,
	val customerAllergens: List<OrderCustomerAllergenDto>?,
	@SerialName("quantity")
	val extraQuantity: Int
)
