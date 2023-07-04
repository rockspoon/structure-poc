package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in

import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.AddDineInOrderDinerRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface DineInDinerApi {

	@POST("order/v1/dine-in/{orderId}/diner")
	suspend fun addDinerToOrder(
		@Path("orderId") orderId: String,
		@Body request: List<AddDineInOrderDinerRequest>
	)

	@PUT("order/v1/dine-in/{orderId}/diner/{dinerId}")
	suspend fun updateDinerForOrder(
		@Path("orderId") orderId: String,
		@Path("dinerId") dinerId: String,
		@Body request: AddDineInOrderDinerRequest
	)

	@DELETE("order/v1/dine-in/{orderId}/diner")
	suspend fun removeDinerFromOrder(
		@Path("orderId") orderId: String,
		@Query("dinerId") dinerId: List<String>
	)
}