package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * BankAccountDTO DTO
 *
 * @param accountNumber
 * @param accountType
 * @param bankName
 * @param id
 * @param routingNumber
 */
@Serializable
data class BankAccountDTO(
    val accountNumber: String? = null,
    val accountType: String? = null,
    val bankName: String? = null,
    val id: String? = null,
    val routingNumber: String? = null
)

