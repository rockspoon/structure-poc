@file:UseSerializers(BigDecimalSerializer::class)

package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * OrderCheckEntry represents the check entry response in generic order
 *
 * @param id
 * @param splitParts
 * @param splitTotal
 * @param splitGroupId
 * @param orderItemId
 * @param restaurantBundleItemId
 * @param sourceCheckId ID of the original check of this entry if it was
 *     moved
 * @param parent
 * @param name
 * @param status
 * @param percentage
 * @param unitPrice
 * @param grossPrice
 * @param netPrice
 * @param type
 * @param itemId
 * @param menuName
 * @param sectionName
 * @param description
 * @param photo
 * @param isComp
 */
@Serializable
data class OrderCheckEntry(
    val id: String? = null,
    val splitParts: BigDecimal? = null,
    val splitTotal: BigDecimal? = null,
    val splitGroupId: String? = null,
    val orderItemId: String? = null,
    val restaurantBundleItemId: String? = null,
    /** ID of the original check of this entry if it was moved */
    val sourceCheckId: String? = null,
    val parent: String? = null,
    val name: String? = null,
    val status: String? = null,
    val percentage: BigDecimal? = null,
    val unitPrice: String? = null,
    val grossPrice: String? = null,
    val netPrice: String? = null,
    val type: String? = null,
    val itemId: String? = null,
    val menuName: String? = null,
    val sectionName: String? = null,
    val description: String? = null,
    val photo: String? = null,
    val isComp: Boolean? = null
)

