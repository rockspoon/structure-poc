package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in

import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.OrderItemWithMetaInfoDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.UpdateSeatsAndCourseRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DineInItemApi {

	@GET("order/v1/dine-in/item")
	suspend fun fetchDineInItems(@Query("orderStatus") orderStatus: String): List<OrderItemWithMetaInfoDto>

	@PATCH("order/v1/dine-in/{orderId}/item")
	suspend fun updateSeatsAndCourse(
		@Path("orderId") orderId: String,
		@Body request: UpdateSeatsAndCourseRequest
	)

	@POST("order/v1/dine-in/{orderId}/item/{orderItemId}/transfer-to-order/{newOrderId}")
	suspend fun transferOrderItem(
		@Path("orderId") orderId: String,
		@Path("orderItemId") orderItemId: String,
		@Path("newOrderId") newOrderId: String
	)
}