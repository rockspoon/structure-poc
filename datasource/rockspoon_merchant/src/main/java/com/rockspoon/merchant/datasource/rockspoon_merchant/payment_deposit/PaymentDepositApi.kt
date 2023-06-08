package com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_URL_PATH
import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_USER_INTERACTION_UUID
import com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model.CreatePaymentDepositRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model.PaymentDepositDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model.PaymentDepositIdResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model.PaymentDepositStatusDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.payment_deposit.model.UpdatePaymentDepositRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

private const val PAYMENT_DEPOSIT_PATH = "payment/deposit"
private const val PAYMENT_DEPOSIT_BY_ID_PATH = "payment/deposit/{depositId}"

interface PaymentDepositApi {

	@Headers(HEADER_URL_PATH + PAYMENT_DEPOSIT_PATH)
	@GET(PAYMENT_DEPOSIT_PATH)
	suspend fun getPaymentDeposits(
		@Query("status") status: PaymentDepositStatusDto?,
		@Query("expired") expired: Boolean?
	): List<PaymentDepositDto>

	@Headers(HEADER_URL_PATH + PAYMENT_DEPOSIT_BY_ID_PATH)
	@GET(PAYMENT_DEPOSIT_BY_ID_PATH)
	suspend fun getPaymentDepositById(
		@Header(HEADER_USER_INTERACTION_UUID) uuidEvent: String?,
		@Path("depositId") depositId: String
	): PaymentDepositDto

	@Headers(HEADER_URL_PATH + PAYMENT_DEPOSIT_PATH)
	@POST(PAYMENT_DEPOSIT_PATH)
	suspend fun createPaymentDeposit(
		@Header(HEADER_USER_INTERACTION_UUID) uuidEvent: String?,
		@Body request: CreatePaymentDepositRequest
	): PaymentDepositIdResponse

	@Headers(HEADER_URL_PATH + PAYMENT_DEPOSIT_BY_ID_PATH)
	@PUT(PAYMENT_DEPOSIT_BY_ID_PATH)
	suspend fun updatePaymentDeposit(
		@Path("depositId") id: String,
		@Body request: UpdatePaymentDepositRequest
	)
}