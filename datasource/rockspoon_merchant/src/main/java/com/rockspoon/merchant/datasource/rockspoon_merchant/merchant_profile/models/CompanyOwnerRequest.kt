package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param businessName Business Name.
 * @param email Business Email.
 * @param firstName Owner's First Name.
 * @param lastName Owner's Last Name.
 * @param phone Phone Number.
 * @param share Company's Share.
 * @param tin Business TIN.
 * @param ownersInfo
 */
@Serializable
data class CompanyOwnerRequest(
    val address: Address,
    /** Business Name. */
    val businessName: String,
    /** Business Email. */
    val email: String,
    /** Owner's First Name. */
    val firstName: String,
    /** Owner's Last Name. */
    val lastName: String,
    /** Phone Number. */
    val phone: String,
    /** Company's Share. */
    val share: kotlin.Float,
    /** Business TIN. */
    val tin: String,
    val ownersInfo: List<IndividualOwnerRequest>? = null
)

