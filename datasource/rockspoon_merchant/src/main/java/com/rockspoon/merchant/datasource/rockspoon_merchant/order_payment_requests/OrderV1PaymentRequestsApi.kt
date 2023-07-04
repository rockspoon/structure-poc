package com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_ACCESS_TOKEN
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model.CreatePaymentRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_payment_requests.model.PaymentRequestDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface OrderV1PaymentRequestsApi {

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=allPaymentRequests">allPaymentRequests</a>
	 */
	@GET("order/v1/payment-requests")
	suspend fun getPaymentRequests(
		@Query("orderId") orderId: String? = null,
		@Query("matchProfile") matchProfile: Boolean? = null,
		@Query("status") status: List<String>? = null,
	): List<PaymentRequestDto>

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=createPaymentRequest">createPaymentRequest</a>
	 */
	@POST("order/v1/payment-requests")
	suspend fun createPaymentRequest(@Body request: CreatePaymentRequest)

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=deletePaymentRequest">deletePaymentRequest</a>
	 */
	@DELETE("order/v1/payment-requests/{id}")
	suspend fun deletePaymentRequest(
		@Header(HEADER_ACCESS_TOKEN) accessToken: String? = null,
		@Path("id") paymentRequestId: String
	)
}