package com.rockspoon.merchant.datasource.rockspoon_merchant.order_settings

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_settings.model.OrdersViewSettingsDto
import retrofit2.http.GET

interface OrderV1SettingsApi {

	/**
	 * 	@see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=get-venue-settings">get-venue-settings</a>
	 */
	@GET("order/v1/venue/settings")
	suspend fun getOrderSettings(): OrdersViewSettingsDto
}