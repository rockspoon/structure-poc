package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param address
 * @param dateOfBirth
 * @param documentDetails
 * @param email
 * @param firstName
 * @param hubSpotContactID
 * @param lastName
 * @param legalAddress
 * @param middleName
 * @param nationality
 * @param phoneNumber
 * @param residingCountry
 * @param secondaryNationality
 * @param share
 * @param socialSecurityNumber
 * @param socialSecurityType
 */
@Serializable
data class IndividualOwner(
    val address: Address? = null,
    val dateOfBirth: String? = null,
    val documentDetails: OwnerDocumentDetails? = null,
    val email: String? = null,
    val firstName: String? = null,
    val hubSpotContactID: Long? = null,
    val lastName: String? = null,
    val legalAddress: Address? = null,
    val middleName: String? = null,
    val nationality: String? = null,
    val phoneNumber: String? = null,
    val residingCountry: String? = null,
    val secondaryNationality: String? = null,
    val share: kotlin.Float? = null,
    val socialSecurityNumber: String? = null,
    val socialSecurityType: SocialSecurityType? = null
) {

    /** Values: sSN */
    @Serializable
    enum class SocialSecurityType(val value: String) {

        @SerialName("SSN")
        SSN("SSN");

    }

}

