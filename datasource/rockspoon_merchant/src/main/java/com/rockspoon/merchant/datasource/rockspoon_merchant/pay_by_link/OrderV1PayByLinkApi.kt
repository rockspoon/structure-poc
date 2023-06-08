package com.rockspoon.merchant.datasource.rockspoon_merchant.pay_by_link

import com.rockspoon.merchant.datasource.rockspoon_merchant.pay_by_link.models.PayByLinkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderV1PayByLinkApi {

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=CreatePayByLink">CreatePayByLink</a>
	 */
	@POST("order/v1/pay-by-link/{id}")
	suspend fun createPaymentLink(@Path("id") checkId: String): PayByLinkResponse
}