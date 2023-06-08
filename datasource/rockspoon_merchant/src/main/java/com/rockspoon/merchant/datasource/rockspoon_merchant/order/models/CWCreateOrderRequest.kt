@file:UseSerializers(BigDecimalSerializer::class)
package com.rockspoon.merchant.datasource.rockspoon_merchant.order.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.CarInfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal

/**
 * @param venueId
 * @param orderType
 * @param scheduledTime
 * @param cctoken required for not `none` payment type
 * @param paymentType Payment type that should be updated. Default is
 *     my-own
 * @param comment
 * @param name
 * @param domain
 * @param addressId
 * @param address
 * @param carInfoDto
 * @param orderItems
 * @param floorPlanElementIds
 * @param floorPlanSectionId
 * @param tips amount of tips in cents
 */
@Serializable
data class CWCreateOrderRequest(
    val venueId: String,
    val orderType: OrderType,
    val domain: Domain,
    val scheduledTime: String? = null,
    /** required for not `none` payment type */
    val cctoken: String? = null,
    /** Payment type that should be updated. Default is my-own */
    val paymentType: GuestPaymentType? = null,
    val comment: String? = null,
    val name: String? = null,
    val addressId: String? = null,
    val address: CWCreateOrderRequestAddress? = null,
    val carInfoDto: CarInfoDto? = null,
    val orderItems: List<OrderItemConsumerRequest>? = null,
    val floorPlanElementIds: List<String>? = null,
    val floorPlanSectionId: String? = null,
    /** amount of tips in cents */
    val tips: BigDecimal? = null
) {

    /** Values: delivery,takeout,curbside,DINE_IN */
    @Serializable
    enum class OrderType(val value: String) {

        @SerialName("delivery")
        DELIVERY("delivery"),

        @SerialName("takeout")
        TAKEOUT("takeout"),

        @SerialName("curbside")
        CURBSIDE("curbside"),

        @SerialName("dine-in")
        DINE_IN("dine-in");

    }

    /** Values: restaurant */
    @Serializable
    enum class Domain(val value: String) {

        @SerialName("restaurant")
        RESTAURANT("restaurant");

    }

}

