package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * GiactPersonDataRecord is something to hold person data records
 *
 * @param AddressRecords
 * @param DateOfBirth
 * @param FirstName
 * @param IdNumber
 * @param LastName
 * @param MiddleName
 * @param PhoneNumbers
 * @param SsnIssueEndYear
 * @param SsnIssueStartYear
 * @param SsnIssueState
 * @param SsnStatus
 */
@Serializable
data class GiactPersonDataRecord(
    @SerialName("AddressRecords")
    val addressRecords: GiactResidentialAddressRecords? = null,
    @SerialName("DateOfBirth")
    val dateOfBirth: String? = null,
    @SerialName("FirstName")
    val firstName: String? = null,
    @SerialName("IdNumber")
    val idNumber: String? = null,
    @SerialName("LastName")
    val lastName: String? = null,
    @SerialName("MiddleName")
    val middleName: String? = null,
    @SerialName("PhoneNumbers")
    val phoneNumbers: GiactPhoneNumbers? = null,
    @SerialName("SsnIssueEndYear")
    val ssnIssueEndYear: String? = null,
    @SerialName("SsnIssueStartYear")
    val ssnIssueStartYear: String? = null,
    @SerialName("SsnIssueState")
    val ssnIssueState: String? = null,
    @SerialName("SsnStatus")
    val ssnStatus: String? = null
)

