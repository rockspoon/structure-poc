@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PriceDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BundleTypeDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * GenericOrderItemResponse represents the items of an order
 *
 * @param description
 * @param createdAt
 * @param isComp
 * @param toGo
 * @param itemId
 * @param name
 * @param orderItemId
 * @param metadata
 * @param isAvailable
 * @param unavailabilityReason
 * @param customers
 * @param orderMetaInfo
 * @param status
 * @param servingOption required only for dine-in type
 * @param taxRule
 * @param course
 * @param allSeats
 * @param numberOfPlates
 * @param quantity
 * @param isBundleItemCompleted
 * @param bundleItems
 * @param bundleType
 * @param addedBy
 * @param menuName
 * @param menuSectionName
 * @param category
 * @param subcategory
 * @param itemCategory
 * @param deliveredBy
 * @param price
 * @param customerAllergens
 */
@Serializable
data class GenericOrderItemResponse(
    val description: String? = null,
    val createdAt: Instant? = null,
    val isComp: Boolean? = null,
    val toGo: Boolean? = null,
    val itemId: String? = null,
    val name: String? = null,
    val orderItemId: String? = null,
    val metadata: ItemMetaData? = null,
    val isAvailable: Boolean? = null,
    val unavailabilityReason: String? = null,
    val customers: List<GenericCustomerResponse>? = null,
    val orderMetaInfo: OrderMetaInfo? = null,
    val status: Status? = null,
    /** required only for dine-in type */
    val servingOption: ServingOptionDto? = null,
    val taxRule: TaxRule? = null,
    val course: BigDecimal? = null,
    val allSeats: Boolean? = null,
    val numberOfPlates: Int? = null,
    val quantity: BigDecimal? = null,
    val isBundleItemCompleted: Boolean? = null,
    val bundleItems: List<BundleItem>? = null,
    val bundleType: BundleTypeDto? = null,
    val addedBy: AddedBy? = null,
    val menuName: String? = null,
    val menuSectionName: String? = null,
    val category: String? = null,
    val subcategory: String? = null,
    val itemCategory: String? = null,
    val deliveredBy: String? = null,
    val price: PriceDto? = null,
    val customerAllergens: List<CustomerAllergenResponse>? = null
) {

    /** Values: canceled,pending,fired,fulfilledWithoutFiring,voided */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("canceled")
        CANCELED("canceled"),

        @SerialName("pending")
        PENDING("pending"),

        @SerialName("fired")
        FIRED("fired"),

        @SerialName("fulfilled_without_firing")
        FULFILLED_WITHOUT_FIRING("fulfilled_without_firing"),

        @SerialName("voided")
        VOIDED("voided");

    }

    /** Values: default,tax_free */
    @Serializable
    enum class TaxRule(val value: String) {

        @SerialName("default")
        DEFAULT("default"),

        @SerialName("tax-free")
        TAX_FREE("tax-free");

    }

}

