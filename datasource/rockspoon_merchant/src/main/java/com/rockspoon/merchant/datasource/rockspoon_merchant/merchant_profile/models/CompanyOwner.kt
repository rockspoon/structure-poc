package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param businessName
 * @param email
 * @param firstName
 * @param hubSpotContactID
 * @param lastName
 * @param phone
 * @param share
 * @param tin
 * @param ownersInfo
 */
@Serializable
data class CompanyOwner(
    val address: Address? = null,
    val businessName: String? = null,
    val email: String? = null,
    val firstName: String? = null,
    val hubSpotContactID: Long? = null,
    val lastName: String? = null,
    val phone: String? = null,
    val share: kotlin.Float? = null,
    val tin: String? = null,
    val ownersInfo: List<IndividualOwner>? = null
)

