package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * SalesTax represents sales tax model
 *
 * @param salesTax
 * @param creationDate
 * @param effectiveDate
 */
@Serializable
data class SalesTax(
    val salesTax: Double? = null,
    val creationDate: Instant? = null,
    val effectiveDate: Instant? = null
)

