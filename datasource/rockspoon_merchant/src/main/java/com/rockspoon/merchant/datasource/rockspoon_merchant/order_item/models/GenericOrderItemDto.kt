package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models.BundleItemDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class GenericOrderItemDto(
    val orderItemId: String,
    @SerialName("itemId")
    val catalogItemId: String?,
    val name: String,
    val description: String,
    val numberOfPlates: Int?,
    val course: Int?,
    val customers: List<GenericOrderItemCustomerDto>?,
    val isAvailable: Boolean?,
    val unavailabilityReason: String?,
    val isComp: Boolean,
    val status: Status?,
    val servingOption: ServingOptionDto?,
    @SerialName("metadata")
    val metaData: ItemMetaDataDto,
    val orderMetaInfo: OrderMetaDataDto?,
    @Serializable(with = BigDecimalSerializer::class)
    val quantity: BigDecimal?,
    val isBundleItemsCompleted: Boolean?,
    val bundleItems: List<BundleItemDto>?,
    val bundleType: BundleTypeDto?,
    val addedBy: AddedByDto?,
    val category: CatalogItemCategoryDto?,
    val subcategory: BeverageCategoryDto?,
    val routings: List<String>?,
    val customerAllergens: List<OrderCustomerAllergenDto>?,
    val taxRule: ItemTaxRuleDto
) {


    @Serializable
    enum class Status {
        @SerialName("pending")
        PENDING,

        @SerialName("fired")
        FIRED,

        @SerialName("canceled")
        CANCELED,

        @SerialName("voided")
        VOIDED,

        @SerialName("fulfilled_without_firing")
        FULFILLED_WITHOUT_FIRING;
    }
}
