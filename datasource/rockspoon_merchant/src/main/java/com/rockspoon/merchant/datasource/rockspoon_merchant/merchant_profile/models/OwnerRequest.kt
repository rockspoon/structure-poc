package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param companies
 * @param individuals
 */
@Serializable
data class OwnerRequest(
    val companies: List<CompanyOwnerRequest>? = null,
    val individuals: List<IndividualOwnerRequest>? = null
)

