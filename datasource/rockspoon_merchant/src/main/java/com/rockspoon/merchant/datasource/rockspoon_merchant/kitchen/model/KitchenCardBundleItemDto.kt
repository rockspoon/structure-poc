package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KitchenCardBundleItemDto(
	@SerialName("bundleItemId")
	val bundleCatalogItemId: String,
	val description: String?,
	val name: String,
	@SerialName("orderBundleItemId")
	val bundleOrderItemId: String,
	@SerialName("itemId")
	val originalCatalogItemId: String?
)