package com.rockspoon.merchant.datasource.rockspoon_merchant.order_item

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_ACCESS_TOKEN
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.GenericOrderItemDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.GenericOrderItemListDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.OrderItemsStatusesDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.AddOpenFoodItemToCardRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.AddOrderItemToCardRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.DiscountRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.FireOrderItemsRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.OrderItemIdsRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.OrderItemUpdateQuantityRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.OrderItemUpdateRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.UncompItemRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.UnfireOrderItemRequestDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.models.request.VoidItemRequestDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

@Suppress("ComplexInterface")
interface OrderItemApi {

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=addOrderItemsHandler">addOrderItemsHandler</a>
     */
    @POST("order/v1/{orderId}/item")
    suspend fun addItemToOrder(
        @Path("orderId") orderId: String,
        @Body request: AddOrderItemToCardRequestDto
    ): GenericOrderItemListDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=updateOrderItemHandler">updateOrderItemHandler</a>
     */
    @PUT("order/v1/{orderId}/item/{itemId}/quantity")
    suspend fun updateOrderItemAndQuantity(
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Body request: OrderItemUpdateQuantityRequestDto
    ): GenericOrderItemDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=addOrderItemsHandler">addOrderItemsHandler</a>
     */
    @POST("order/v1/{orderId}/manual-item")
    suspend fun addOpenFoodItemToOrder(
        @Path("orderId") orderId: String,
        @Body request: AddOpenFoodItemToCardRequestDto
    ): GenericOrderItemListDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=updateOrderItemHandler">updateOrderItemHandler</a>
     */
    @PUT("order/v1/{orderId}/item/{itemId}")
    suspend fun updateOrderItem(
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Body request: OrderItemUpdateRequestDto
    ): GenericOrderItemDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=deleteOrderItemHandler">deleteOrderItemHandler</a>
     */
    @DELETE("order/v1/{orderId}/item/{itemId}/restaurantBundleItem")
    suspend fun removeBundleItemsFromOrder(
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Query("restaurantBundleItemId") bundleOrderItemIds: List<String>
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=removeOrderItemsGeneric">removeOrderItemsGeneric</a>
     */
    @DELETE("order/v1/{orderId}/item")
    suspend fun removeItemsFromOrder(
        @Path("orderId") orderId: String,
        @Query("orderItemId") itemIds: List<String>
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=removeRestaurantBundleItem">removeRestaurantBundleItem</a>
     */
    @DELETE("order/v1/{orderId}/item/{itemId}/restaurantBundleItem/{bundleOrderItemId}")
    suspend fun removeBundleItemFromOrder(
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Path("bundleOrderItemId") bundleOrderItemId: String
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=removeOrderItemGeneric">removeOrderItemGeneric</a>
     */
    @DELETE("order/v1/{orderId}/item/{itemId}")
    suspend fun removeItemFromOrder(
        @Path("orderId") orderId: String,
        @Path("itemId") itemId: String
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=fireItemGeneric">fireItemGeneric</a>
     */
    @POST("order/v1/{orderId}/item/fire")
    suspend fun fireOrderItems(
        @Path("orderId") orderId: String,
        @Body request: FireOrderItemsRequestDto
    ): OrderItemsStatusesDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=unfireItemGeneric">unfireItemGeneric</a>
     */
    @POST("order/v1/{orderId}/item/unfire")
    suspend fun unfireOrderItems(
        @Path("orderId") orderId: String,
        @Body request: UnfireOrderItemRequestDto
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=repeatItemGeneric">repeatItemGeneric</a>
     */
    @POST("order/v1/{orderId}/repeat-item")
    suspend fun repeatItems(
        @Path("orderId") orderId: String,
        @Body request: OrderItemIdsRequestDto
    ): GenericOrderItemListDto

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=compOrderItem">compOrderItem</a>
     */
    @POST("order/v1/{orderId}/item/{itemId}/comp")
    suspend fun compRegularOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Body request: DiscountRequestDto
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=compBundleItemGeneric">compBundleItemGeneric</a>
     */
    @POST("order/v1/{orderId}/item/{itemId}/restaurantBundleItem/{bundleOrderItemId}/comp")
    suspend fun compBundledOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Path("bundleOrderItemId") bundleOrderItemId: String,
        @Body request: DiscountRequestDto
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=removeItemDiscountsHandlerGeneric">removeItemDiscountsHandlerGeneric</a>
     */
    @HTTP(method = "DELETE", path = "order/v1/{orderId}/item/{itemId}/discount", hasBody = true)
    suspend fun uncompRegularOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Body request: UncompItemRequestDto?
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=removeBundleItemDiscountsHandlerGeneric">removeBundleItemDiscountsHandlerGeneric</a>
     */
    @HTTP(method = "DELETE", path = "order/v1/{orderId}/item/{itemId}/restaurantBundleItem/{bundleOrderItemId}/discount", hasBody = true)
    suspend fun uncompBundleOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Path("bundleOrderItemId") bundleOrderItemId: String,
        @Body request: UncompItemRequestDto?
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=voidItemGeneric">voidItemGeneric</a>
     */
    @POST("order/v1/{orderId}/item/{itemId}/void")
    suspend fun voidRegularOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Body request: VoidItemRequestDto
    )

    /**
     * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=voidBundleItemGeneric">voidBundleItemGeneri</a>
     */
    @POST("order/v1/{orderId}/item/{itemId}/restaurantBundleItem/{bundleOrderItemId}/void")
    suspend fun voidBundledOrderItem(
        @Header(HEADER_ACCESS_TOKEN) accessToken: String?,
        @Path("orderId") orderId: String,
        @Path("itemId") orderItemId: String,
        @Path("bundleOrderItemId") bundleOrderItemId: String,
        @Body request: VoidItemRequestDto
    )
}
