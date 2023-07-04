package com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt

import com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt.models.PrintingJobPayloadDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt.models.SendReceiptRequestDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE = "order/v1/receipt"

interface OrderReceiptApi {

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=printPaymentV2Receipt&definition=PrintPayload">PrintPayload</a>
	 */
	@GET("$BASE/payment/{paymentId}/print")
	suspend fun getPaymentReceiptPrintingJobPayload(
		@Path("paymentId") paymentId: String,
		@Query("securityDepositId") securityDepositId: String?,
		@Query("payOnPaper") payOnPaper: Boolean?
	): PrintingJobPayloadDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=printRefundV2Receipt">printRefundV2Receipt</a>
	 */
	@GET("$BASE/refund/{refundId}/print")
	suspend fun getRefundReceiptPrintingJobPayload(
		@Path("refundId") refundId: String,
		@Query("securityDepositId") securityDepositId: String?
	): PrintingJobPayloadDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=sendPaymentReceipt">sendPaymentReceipt</a>
	 */
	@POST("$BASE/payment/{paymentId}/send")
	suspend fun sendPaymentReceipt(
		@Path("paymentId") paymentId: String,
		@Body request: SendReceiptRequestDto
	)

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=order-v1&operation=sendRefundReceipt">sendRefundReceipt</a>
	 */
	@POST("$BASE/refund/{refundId}/send")
	suspend fun sendRefundReceipt(
		@Path("refundId") refundId: String,
		@Body request: SendReceiptRequestDto
	)


}