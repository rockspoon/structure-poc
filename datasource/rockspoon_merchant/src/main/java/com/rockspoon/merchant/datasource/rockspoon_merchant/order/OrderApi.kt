package com.rockspoon.merchant.datasource.rockspoon_merchant.order

import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.BagResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.ChangeBagRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.CreateBagRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.OrderSummaryResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.models.PrintPayload
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface OrderApi {

    @GET("order/v1/{orderId}/bag")
    suspend fun getBags(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("orderId") orderId: String
    ): List<BagResponse>

    @POST("order/v1/{orderId}/bag")
    suspend fun addBag(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("orderId") orderId: String,
        @Body payload: CreateBagRequest
    ): BagResponse

    @DELETE("order/v1/{orderId}/bag/{bagId}")
    suspend fun deletBag(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("orderId") orderId: String,
        @Path("bagId") bagId: String
    )

    /** change bag parameters. */
    @PATCH("order/v1/{orderId}/bag/{bagId}")
    suspend fun patchBag(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("orderId") orderId: String,
        @Path("bagId") bagId: String,
        @Body payload: ChangeBagRequest
    )

    /** Returns all order bags in printed form */
    @GET("order/v1/receipt/check/{checkId}/bag/print")
    suspend fun printBagReceiptList(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("checkId") checkId: String,
        @Query("paymentId") paymentId: String?
    ): List<PrintPayload>

    /** Returns a specific bag printed receipt */
    @GET("order/v1/receipt/check/{checkId}/bag/{bagId}/print")
    suspend fun printBagReceipt(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("checkId") checkId: String,
        @Path("bagId") bagId: String,
        @Query("paymentId") paymentId: String?
    ): PrintPayload

    @GET("order/v1/summary")
    suspend fun getOrderSummary(): OrderSummaryResponse
}