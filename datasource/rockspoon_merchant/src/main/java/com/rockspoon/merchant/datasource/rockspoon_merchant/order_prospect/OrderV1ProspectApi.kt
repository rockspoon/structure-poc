package com.rockspoon.merchant.datasource.rockspoon_merchant.order_prospect

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_prospect.model.ProspectDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface OrderV1ProspectApi {

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=getProspect">getProspect</a>
	 */
	@GET("order/v1/prospect")
	suspend fun getProspectByCardNumber(@Query("redactedCardNumber") redactedCardNumber: String): ProspectDto

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=post-prospect">post-prospect</a>
	 */
	@POST("order/v1/prospect")
	suspend fun createProspect(@Body request: ProspectDto)

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=put-prospect-prospectid">put-prospect-prospectid</a>
	 */
	@PUT("order/v1/prospect/{id}")
	suspend fun updateProspect(@Path("id") prospectId: String, @Body request: ProspectDto)
}