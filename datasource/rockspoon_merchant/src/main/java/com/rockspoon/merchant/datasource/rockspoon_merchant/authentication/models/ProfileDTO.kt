package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param preferences
 * @param addresses
 * @param bankAccount
 * @param birthDate
 * @param createdBy
 * @param customerPicture
 * @param deletedBy
 * @param email
 * @param emailToken
 * @param emails
 * @param employeePicture
 * @param id
 * @param inviteSendAt
 * @param isRockspoonUser
 * @param jobPosition
 * @param mainTenant
 * @param pendingNewEmail
 * @param phone
 * @param phones
 * @param referralCount
 * @param referralId
 * @param referralTermsAcceptedAt
 * @param restaurantName
 * @param updatedBy
 * @param userId
 * @param venues
 */
@Serializable
data class ProfileDTO(
    @SerialName("Preferences")
    val preferences: PreferencesDTO? = null,
    val addresses: List<Address>? = null,
    val bankAccount: List<BankAccountDTO>? = null,
    val birthDate: String? = null,
    val createdBy: String? = null,
    val customerPicture: ImageDTO? = null,
    val deletedBy: String? = null,
    val email: String? = null,
    val emailToken: String? = null,
    val emails: List<Email>? = null,
    val employeePicture: ImageDTO? = null,
    val id: String? = null,
    val inviteSendAt: Instant? = null,
    val isRockspoonUser: Boolean? = null,
    val jobPosition: String? = null,
    val mainTenant: MainTenantDTO? = null,
    val pendingNewEmail: String? = null,
    val phone: Phone? = null,
    val phones: List<Phone>? = null,
    val referralCount: Long? = null,
    val referralId: String? = null,
    val referralTermsAcceptedAt: Instant? = null,
    val restaurantName: String? = null,
    val updatedBy: String? = null,
    val userId: String? = null,
    val venues: List<VenueDTO>? = null
)

