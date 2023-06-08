package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param companies
 * @param individual
 */
@Serializable
data class Shareholders(
    val companies: List<CompanyOwner>? = null,
    val individual: List<IndividualOwner>? = null
)

