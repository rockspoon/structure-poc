package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in

import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.models.TransferCheckRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface DineInCheckApi {

	@POST("order/v1/dine-in/{orderId}/check/{checkId}/transfer")
	suspend fun transferCheck(
		@Header("access_token") accessToken: String?,
		@Path("orderId") orderId: String,
		@Path("checkId") orderItemId: String,
		@Body request: TransferCheckRequest
	)

	@POST("order/v1/dine-in/{orderId}/check/{checkId}/close")
	suspend fun closeSeat(
		@Path("orderId") orderId: String,
		@Path("checkId") checkId: String
	)

	@POST("order/v1/dine-in/{orderId}/check/{checkId}/force-close")
	suspend fun forceCloseSeat(
		@Path("orderId") orderId: String,
		@Path("checkId") checkId: String
	)

	@POST("order/v1/dine-in/{orderId}/check/{checkId}/entry/{entryId}/merge")
	suspend fun mergeSplitItem(
		@Header("access_token") accessToken: String?,
		@Path("orderId") orderId: String,
		@Path("checkId") checkId: String,
		@Path("entryId") entryId: String
	)

}