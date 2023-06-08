package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param address
 * @param birthDate
 * @param businessEntities
 * @param currentRole
 * @param customerPicture
 * @param email user's default email
 * @param emails user's emails
 * @param emergencyContact
 * @param employeePicture
 * @param firstName first name of the user
 * @param id profile ID
 * @param inviteSendAt
 * @param lastName last name of the user
 * @param packages
 * @param pendingNewEmail
 * @param phone
 * @param phones list of user phones
 * @param preferences
 * @param referralCount
 * @param referralTermsAcceptedAt
 * @param restaurantName
 * @param role
 * @param roles
 * @param status status of the user's profile
 * @param type
 * @param typefaceSettings
 * @param username name of the user
 * @param venue
 * @param venueId
 */
@Serializable
data class UserProfileInfoResponse(
    val address: AddressResp,
    /** user's default email */
    val email: String,
    /** user's emails */
    val emails: List<String>,
    /** first name of the user */
    val firstName: String,
    /** profile ID */
    val id: String,
    /** last name of the user */
    val lastName: String,
    val phone: PhoneResp,
    /** list of user phones */
    val phones: List<PhoneResp>,
    /** status of the user's profile */
    val status: String,
    /** name of the user */
    val username: String,
    val birthDate: String? = null,
    val businessEntities: Map<String, BusinessEntityAccess>? = null,
    val currentRole: RoleResp? = null,
    val customerPicture: ImageResp? = null,
    val emergencyContact: EmergencyContactResp? = null,
    val employeePicture: ImageResp? = null,
    val inviteSendAt: Instant? = null,
    val packages: List<String>? = null,
    val pendingNewEmail: String? = null,
    val preferences: PreferencesResponse? = null,
    val referralCount: Long? = null,
    val referralTermsAcceptedAt: Instant? = null,
    val restaurantName: String? = null,
    val role: RoleResp? = null,
    val roles: List<RoleResp>? = null,
    val type: String? = null,
    val typefaceSettings: TypefaceSettings? = null,
    val venue: UserProfileVenueInfo? = null,
    val venueId: String? = null
)

