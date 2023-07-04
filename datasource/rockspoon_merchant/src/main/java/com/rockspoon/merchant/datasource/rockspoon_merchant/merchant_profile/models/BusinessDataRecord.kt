package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * BusinessDataRecord is a biz data record
 *
 * @param addressRecords
 * @param bankruptcyCreditorRecordCount
 * @param bankruptcySubjectRecordCount
 * @param businessContacts
 * @param businessReportKey
 * @param corporationType
 * @param domains
 * @param dunsNumber
 * @param fein
 * @param filingNumber
 * @param incorporationDate
 * @param incorporationState
 * @param industries
 * @param matchingBusinessContactFound
 * @param miscellaneousDetails
 * @param nameRecords
 * @param phoneNumbers
 * @param registrationType
 */
@Serializable
data class BusinessDataRecord(
    @SerialName("AddressRecords")
    val addressRecords: GiactBusinessAddressRecords? = null,
    @SerialName("BankruptcyCreditorRecordCount")
    val bankruptcyCreditorRecordCount: Long? = null,
    @SerialName("BankruptcySubjectRecordCount")
    val bankruptcySubjectRecordCount: Long? = null,
    @SerialName("BusinessContacts")
    val businessContacts: GiactBusinessContacts? = null,
    @SerialName("BusinessReportKey")
    val businessReportKey: String? = null,
    @SerialName("CorporationType")
    val corporationType: String? = null,
    @SerialName("Domains")
    val domains: ArrayOfString? = null,
    @SerialName("DunsNumber")
    val dunsNumber: String? = null,
    @SerialName("FEIN")
    val fein: String? = null,
    @SerialName("FilingNumber")
    val filingNumber: String? = null,
    @SerialName("IncorporationDate")
    val incorporationDate: String? = null,
    @SerialName("IncorporationState")
    val incorporationState: String? = null,
    @SerialName("Industries")
    val industries: ArrayOfString? = null,
    @SerialName("MatchingBusinessContactFound")
    val matchingBusinessContactFound: Boolean? = null,
    @SerialName("MiscellaneousDetails")
    val miscellaneousDetails: String? = null,
    @SerialName("NameRecords")
    val nameRecords: ArrayOfNameRecords? = null,
    @SerialName("PhoneNumbers")
    val phoneNumbers: GiactPhoneNumbers? = null,
    @SerialName("RegistrationType")
    val registrationType: String? = null
)

