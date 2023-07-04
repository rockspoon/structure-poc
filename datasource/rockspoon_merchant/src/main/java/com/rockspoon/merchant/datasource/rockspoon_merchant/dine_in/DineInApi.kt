package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in

import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.DineInDiningPartyRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.DineInOrderSummaryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.UpdateNeedAssistanceRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.MergeOrdersRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.SetSelectedCourseRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.TransferOrderToTableRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.TransferOrderToWaiterRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.TransferOrdersToWaiterAsManagerRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface DineInApi {

	@POST("order/v1/dine-in")
	suspend fun createDineInOrder(@Body request: DineInDiningPartyRequest): DineInOrderSummaryDto

	@PUT("order/v1/dine-in/{orderId}/floor-plan-element")
	suspend fun transferOrderToTable(
		@Path("orderId") orderId: String,
		@Body request: TransferOrderToTableRequest
	)

	@POST("order/v1/dine-in/{orderId}/merge")
	suspend fun mergeOrders(
		@Header("access_token") accessToken: String?,
		@Path("orderId") orderId: String,
		@Body request: MergeOrdersRequest
	)

	@PUT("order/v1/dine-in/reassign")
	suspend fun transferOrdersToWaiter(
		@Header("access_token") accessToken: String?,
		@Body request: TransferOrderToWaiterRequest
	)

	@PUT("order/v1/dine-in/manager-reassign")
	suspend fun transferOrdersToWaiterByManager(
		@Header("access_token") accessToken: String?,
		@Body request: TransferOrdersToWaiterAsManagerRequest
	)

	@PATCH("order/v1/dine-in/{orderId}")
	suspend fun updateNeedAssistance(
		@Path("orderId") orderId: String,
		@Body needAssistanceRequest: UpdateNeedAssistanceRequest
	)

	@PATCH("order/v1/dine-in/{orderId}")
	suspend fun saveSelectedCourse(
		@Path("orderId") orderId: String,
		@Body setSelectedCourseRequest: SetSelectedCourseRequest
	)
}