package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * OfacListData represents OfacListData
 *
 * @param addresses
 * @param alsoKnownAs
 * @param associations
 * @param citizenships
 * @param dataSource
 * @param dateOfBirthListings
 * @param emailAddress
 * @param entityId
 * @param gender
 * @param lastUpdatedDate
 * @param name
 * @param nationalIds
 * @param nationalities
 * @param passports
 * @param placeOfBirthListings
 * @param programNames
 * @param remarks
 * @param summary
 * @param taxIdNumber
 * @param title
 * @param website
 */
@Serializable
data class OfacListData(
    @SerialName("Addresses")
    val addresses: GiactAddresses? = null,
    @SerialName("AlsoKnownAs")
    val alsoKnownAs: ArrayOfString? = null,
    @SerialName("Associations")
    val associations: ArrayOfString? = null,
    @SerialName("Citizenships")
    val citizenships: ArrayOfString? = null,
    @SerialName("DataSource")
    val dataSource: String? = null,
    @SerialName("DateOfBirthListings")
    val dateOfBirthListings: ArrayOfString? = null,
    @SerialName("EmailAddress")
    val emailAddress: String? = null,
    @SerialName("EntityId")
    val entityId: Long? = null,
    @SerialName("Gender")
    val gender: String? = null,
    @SerialName("LastUpdatedDate")
    val lastUpdatedDate: String? = null,
    @SerialName("Name")
    val name: GiactBusinessName? = null,
    @SerialName("NationalIds")
    val nationalIds: ArrayOfString? = null,
    @SerialName("Nationalities")
    val nationalities: ArrayOfString? = null,
    @SerialName("Passports")
    val passports: ArrayOfString? = null,
    @SerialName("PlaceOfBirthListings")
    val placeOfBirthListings: ArrayOfString? = null,
    @SerialName("ProgramNames")
    val programNames: ArrayOfString? = null,
    @SerialName("Remarks")
    val remarks: String? = null,
    @SerialName("Summary")
    val summary: GiactBusinessSummary? = null,
    @SerialName("TaxIdNumber")
    val taxIdNumber: String? = null,
    @SerialName("Title")
    val title: String? = null,
    @SerialName("Website")
    val website: String? = null
)

