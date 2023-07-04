package com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_USER_INTERACTION_UUID
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PaginationResponseDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.model.OrderCustomerDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE = "order/v1/customer"

interface OrderCustomerApi {

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=getCustomersPaginationHandler">getCustomersPaginationHandler</a>
	 */
	@GET(BASE)
	suspend fun searchCustomers(
		@Query("phoneNumber") search: String?,
		@Query("pageSize") pageSize: Int?,
		@Query("next") nextId: String?
	): PaginationResponseDto<OrderCustomerDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=getCustomerStatsByVenueHandler">getCustomerStatsByVenueHandler</a>
	 */
	@GET("$BASE/{customerId}")
	suspend fun findCustomerById(
		@Header(HEADER_USER_INTERACTION_UUID) uuidEvent: String?,
		@Path("customerId") customerId: String
	): OrderCustomerDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=deleteCustomerCar">deleteCustomerCar</a>
	 */
	@DELETE("$BASE/{customerId}/car/{carId}")
	suspend fun removeCustomerCarById(
		@Path("customerId") customerId: String,
		@Path("carId") carId: String
	)

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=deleteCustomerAddress">deleteCustomerAddress</a>
	 */
	@DELETE("$BASE/{customerId}/address/{addressId}")
	suspend fun deleteCustomerAddress(
		@Path("customerId") customerId: String,
		@Path("addressId") addressId: String
	)

}