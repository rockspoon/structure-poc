package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.OrderCustomerAllergenDto
import kotlinx.serialization.Serializable

@Serializable
sealed class AddToCardRequestDto {
    @Serializable
    data class DineIn(
        // TODO #API_INTEGRATION should be changed to String on server side
        val course: Int?,
        val itemId: String,
        val metadata: ItemMetaDataRequestDto?,
        val numberOfPlates: Int,
        val orderCustomerIds: List<String>,
        val quantity: Int,
        val servingOption: ServingOptionDto,
        val customerAllergens: List<OrderCustomerAllergenDto>?,
    ) : AddToCardRequestDto()

    @Serializable
    data class Takeout(
        val itemId: String,
        val metadata: ItemMetaDataRequestDto?,
        val orderCustomerIds: List<String>,
        val quantity: Int,
        val customerAllergens: List<OrderCustomerAllergenDto>?
    ) : AddToCardRequestDto()

    @Serializable
    data class Bundle(
        val course: Int?,
        val itemId: String,
        val quantity: Int,
        val numberOfPlates: Int,
        val orderCustomerIds: List<String>,
        val servingOption: ServingOptionDto?,
        val metadata: BundleItemMetaDataRequestDto?,
        val customName: String?,
        val customerAllergens: List<OrderCustomerAllergenDto>?
    ) : AddToCardRequestDto()
}
