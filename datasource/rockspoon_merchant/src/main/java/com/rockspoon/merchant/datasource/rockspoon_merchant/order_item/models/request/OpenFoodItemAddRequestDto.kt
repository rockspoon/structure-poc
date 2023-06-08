package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request

import com.rockspoon.merchant.datasource.rockspoon_merchant.common.ServingOptionDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.BeverageCategoryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.CatalogItemCategoryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.OrderCustomerAllergenDto
import kotlinx.serialization.Serializable

@Serializable
data class OpenFoodItemAddRequestDto(
    // TODO #API_INTEGRATION should be changed to String on server side
    val course: Int?,
    val customModifiersSelections: List<CustomModifiersSelectionRequestDto>?,
    val name: String,
    val numberOfPlates: Int?,
    val orderCustomerIds: List<String>,
    val quantity: Int,
    val servingOption: ServingOptionDto?,
    val routings: List<String>?,
    val category: CatalogItemCategoryDto?,
    val subcategory: BeverageCategoryDto?,
    val customerAllergens: List<OrderCustomerAllergenDto>?
)
