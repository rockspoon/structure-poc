package com.rockspoon.merchant.datasource.rockspoon_merchant.order_history

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_history.model.OrderHistoryDto
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE = "order-history/v1"

interface OrderHistoryV1Api {

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-history-v1&operation=getOrderHistory">getOrderHistory</a>
	 */
	@GET("$BASE/{orderId}")
	suspend fun getOrderHistoryById(
		@Path("orderId") orderId: String
	): OrderHistoryDto
}