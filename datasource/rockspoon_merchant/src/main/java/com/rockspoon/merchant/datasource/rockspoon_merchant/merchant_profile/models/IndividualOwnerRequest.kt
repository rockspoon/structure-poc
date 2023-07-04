package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param address
 * @param dateOfBirth Owner's Birth Date.
 * @param documentDetails
 * @param email Owner's Email.
 * @param firstName Owner's First Name.
 * @param lastName Owner's Last Name.
 * @param legalAddress
 * @param nationality Owner's Nationality.
 * @param phoneNumber Owner's Phone Number.
 * @param residingCountry Owner's Residing Country.
 * @param secondaryNationality Owner's Secondary Nationality.
 * @param share Owner's Share.
 * @param socialSecurityNumber Owner's Social Security Number.
 * @param socialSecurityType Owner's Social Security type.
 */
@Serializable
data class IndividualOwnerRequest(
    val documentDetails: DocumentDetailsRequest,
    /** Owner's Email. */
    val email: String,
    /** Owner's First Name. */
    val firstName: String,
    /** Owner's Last Name. */
    val lastName: String,
    val legalAddress: Address,
    /** Owner's Nationality. */
    val nationality: String,
    /** Owner's Phone Number. */
    val phoneNumber: String,
    /** Owner's Residing Country. */
    val residingCountry: String,
    /** Owner's Share. */
    val share: kotlin.Float,
    /** Owner's Social Security type. */
    val socialSecurityType: SocialSecurityType,
    val address: Address? = null,
    /** Owner's Birth Date. */
    val dateOfBirth: String? = null,
    /** Owner's Secondary Nationality. */
    val secondaryNationality: String? = null,
    /** Owner's Social Security Number. */
    val socialSecurityNumber: String? = null
) {

    /** Owner's Social Security type. Values: sSN */
    @Serializable
    enum class SocialSecurityType(val value: String) {

        @SerialName("SSN")
        SSN("SSN");

    }

}

