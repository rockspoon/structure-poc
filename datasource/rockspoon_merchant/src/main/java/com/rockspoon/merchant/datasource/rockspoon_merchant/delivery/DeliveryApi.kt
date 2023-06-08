package com.rockspoon.merchant.datasource.rockspoon_merchant.delivery

import com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models.CreateQuoteRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models.DeliveryQuoteDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.delivery.models.DeliveryResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DeliveryApi {

	@POST("delivery/v1/quote")
	suspend fun createDeliveryQuote(
		@Body bodyRequest: CreateQuoteRequest,
	): DeliveryQuoteDto

	@GET("delivery/v1/delivery/{deliveryId}")
	suspend fun getDelivery(
		@Path("deliveryId") deliveryId: String,
	): DeliveryResponseDto
}