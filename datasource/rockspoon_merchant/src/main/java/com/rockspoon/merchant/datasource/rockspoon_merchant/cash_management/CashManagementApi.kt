package com.rockspoon.merchant.datasource.rockspoon_merchant.cash_management

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface CashManagementApi {

    @GET("cash-management/v1/extract")
    suspend fun getExtractReport(
        @Header("access_token") accessToken: String? = null,
        @Query("startDate") startDate: Instant?,
        @Query("endDate") endDate: Instant?,
    ): ExtractGet200ApplicationJsonResponse

    @POST("cash-management/v1/balance")
    suspend fun createManualBalance(
        @Body confirmBalanceRequest: ConfirmBalanceRequest
    )

    @POST("cash-management/v1/entry")
    suspend fun createCashEntry(
        @Body registerCashTransactionRequest: RegisterCashTransactionDTO
    ): IdResponse

    @Serializable
    data class ExtractGet200ApplicationJsonResponse(
        val dailyBalance: MonetaryValue?,
        val extract: List<ExtractItem>?
    )

    @Serializable
    data class MonetaryValue(
        /** In the docs is Integer, but should be BigDecimal probably or it's cents */
        val amount: Int,
        val symbol: String?
    )

    @Serializable
    data class ExtractItem(
        val entries: List<Entry>,
        val balance: Balance
    )

    @Serializable
    data class Entry(
        val id: Long,
        val amount: MonetaryValue,
        val reason: String,
        val type: String?,
        val waive: Boolean?,
        val paymentId: String?,
        val recipients: List<Recipient>?,
        val createdBy: String?,
        val createdAt: String?,
        val meta: Map<String, String>?
    )

    @Serializable
    data class Balance(
        val manualBalance: MonetaryValue?,
        val oldBalance: MonetaryValue?,
        val createdAt: String?,
        val createdBy: String?,
        val approvedAt: String?,
        val approvedBy: String?
    )

    @Serializable
    data class IdResponse(
        val id: Long?
    )

    @Serializable
    data class ConfirmBalanceRequest(
        /** Amount in cents */
        val amount: Long,
        val approved: Boolean
    )

    @Serializable
    data class RegisterCashTransactionDTO(
        val amount: Long,
        val type: CashActivityType,
        val paymentId: String?,
        val reason: String?,
        val recipients: List<Recipient>?,
        val meta: Map<String, String>?
    )

    @Serializable
    enum class CashActivityType {
        @SerialName("cash_tips")
        CASH_TIPS,

        @SerialName("cash_bill")
        CASH_BILL,

        @SerialName("cash_deposit")
        CASH_DEPOSIT,

        @SerialName("cash_security_deposit")
        CASH_SECURITY_DEPOSIT,

        @SerialName("tips_withdrawal")
        TIPS_WITHDRAWAL,

        @SerialName("withdrawal")
        WITHDRAWAL
    }

    @Serializable
    data class Recipient(
        val id: String,
        val name: String
    )
}