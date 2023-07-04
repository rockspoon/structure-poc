package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * @param accessGroups
 * @param company
 * @param currentRole
 * @param emergencyContact
 * @param endDate
 * @param firstName
 * @param id
 * @param institute
 * @param lastName
 * @param roles
 * @param startDate
 * @param status
 * @param type
 * @param typefaceSettings
 */
@Serializable
data class VenueDTO(
    val accessGroups: List<VenueAccessGroupDTO>? = null,
    val company: String? = null,
    val currentRole: String? = null,
    val emergencyContact: EmergencyContactDTO? = null,
    val endDate: Instant? = null,
    val firstName: String? = null,
    val id: String? = null,
    val institute: String? = null,
    val lastName: String? = null,
    val roles: List<RoleDTO>? = null,
    val startDate: Instant? = null,
    val status: String? = null,
    val type: String? = null,
    val typefaceSettings: TypefaceSettings? = null
)

