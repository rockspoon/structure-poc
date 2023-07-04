package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param emails
 * @param mainTenantID
 * @param mainTenantRoleID
 * @param onlyActiveVenue
 * @param profileIDs
 * @param userIDs
 * @param venueID
 * @param next Next is the entry id which is used to find entry after it.
 * @param pageSize
 * @param previous Previous is the entry id which is used to find entry
 *     before it. If next is provided, then previous won't used.
 */
@Serializable
data class ProfilesByEmailPageRequest(
    @SerialName("Emails")
    val emails: List<String>? = null,
    @SerialName("MainTenantID")
    val mainTenantID: String? = null,
    @SerialName("MainTenantRoleID")
    val mainTenantRoleID: String? = null,
    @SerialName("OnlyActiveVenue")
    val onlyActiveVenue: Boolean? = null,
    @SerialName("ProfileIDs")
    val profileIDs: List<String>? = null,
    @SerialName("UserIDs")
    val userIDs: List<String>? = null,
    @SerialName("VenueID")
    val venueID: String? = null,
    /** Next is the entry id which is used to find entry after it. */
    val next: String? = null,
    val pageSize: Long? = null,
    /**
     * Previous is the entry id which is used to find entry before it. If next
     * is provided, then previous won't used.
     */
    val previous: String? = null
)

