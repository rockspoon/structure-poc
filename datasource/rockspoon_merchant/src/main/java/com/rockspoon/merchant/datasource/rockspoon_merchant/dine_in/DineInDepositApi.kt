package com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in

import retrofit2.http.POST
import retrofit2.http.Path

interface DineInDepositApi {

	@POST("order/v1/dine-in/{orderId}/apply-deposit/{securityDepositId}")
	suspend fun useSecurityDeposit(
		@Path("orderId") orderId: String,
		@Path(
			"securityDepositId"
		) securityDepositId: String
	)

	@POST("order/v1/dine-in/{orderId}/remove-deposit")
	suspend fun removeSecurityDeposit(@Path("orderId") orderId: String)

	@POST("order/v1/dine-in/{orderId}/consume-deposit")
	suspend fun consumeSecurityDeposit(
		@Path("orderId") orderId: String
	)

}