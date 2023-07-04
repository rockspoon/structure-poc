package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models

import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.BundleItemDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model.KitchenCardCustomerAllergenDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BundleTypeDto
import kotlinx.serialization.Serializable

@Serializable
data class OrderItemWithMetaInfoDto(
	val itemId: String? = null,
	val orderItemId: String,
	val description: String,
	val status: DineInOrderItemStatusDto?,
	val allSeats: Boolean,
	val course: Int,
	val price: PriceDto?,
	val isAvailable: Boolean,
	val isComp: Boolean,
	val customerAllergens: List<KitchenCardCustomerAllergenDto>,
	val name: String,
	val numberOfPlates: Int? = null,
	val orderMetaInfo: OrderMetaInfoDto,
	val customers: List<CustomerDto>,
	val servingOption: ServingOptionDto,
	//TODO #AVAILABLE_ITEM_FEATURE make field not nullable after API implementation, ask backend to add this field to response
	val bundleType: BundleTypeDto? = null,
	val bundleItems: List<BundleItemDto>? = null
)
