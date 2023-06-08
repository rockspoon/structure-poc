package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param averageCardTransactionsYear
 * @param averageMontlyCardSales
 * @param cardPresentTransactions
 * @param floorServersAmount
 * @param highestCardTransactionYear
 * @param internetTransactions
 * @param kitchenStationsCount
 * @param mailPhoneTransactions
 * @param tablesCount
 */
@Serializable
data class SalesInformation(
    val averageCardTransactionsYear: Long? = null,
    val averageMontlyCardSales: Long? = null,
    val cardPresentTransactions: Long? = null,
    val floorServersAmount: Long? = null,
    val highestCardTransactionYear: Long? = null,
    val internetTransactions: Long? = null,
    val kitchenStationsCount: Long? = null,
    val mailPhoneTransactions: Long? = null,
    val tablesCount: Long? = null
)

