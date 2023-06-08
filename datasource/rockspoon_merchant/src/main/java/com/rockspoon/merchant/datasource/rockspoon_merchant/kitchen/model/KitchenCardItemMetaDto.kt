package com.rockspoon.merchant.datasource.rockspoon_merchant.kitchen.model

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemCategory
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.ItemSubtype
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class KitchenCardItemMetaDto(
    @SerialName("itemId")
	val catalogItemId: String,
    val orderItemId: String,
    val servingType: ServingOptionDto?,
    val seatNumbers: List<String>?,
    val course: Int,
    @Serializable(with = BigDecimalSerializer::class)
	val quantity: BigDecimal?,
    val measure: String?,
    @SerialName("statuses")
	val routingStatuses: List<KitchenCardItemRoutingStatusDto>?,
    val statusHistory: List<KitchenCardItemRoutingStatusHistoryDto>,
    val unavailabilityReason: String?,
    val isAvailable: Boolean?,
    val numberOfPlates: Int?,
    val bundleAttributes: KitchenCardItemBundleAttributesDto?,
    val category: ItemCategory?,
    val subcategory: ItemSubtype?,
    val customerAllergens: List<KitchenCardCustomerAllergenDto>?,
    @SerialName("toGo")
	val isToGo: Boolean?
)
