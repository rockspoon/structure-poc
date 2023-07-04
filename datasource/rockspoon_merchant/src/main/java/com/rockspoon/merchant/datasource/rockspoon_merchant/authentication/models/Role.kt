package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Role venue's access role
 *
 * @param category
 * @param createdAt
 * @param createdBy
 * @param defaultRoleID
 * @param deletedAt
 * @param deletedBy
 * @param description
 * @param employmentConditions
 * @param employmentConditionsHistory
 * @param groupID
 * @param id
 * @param isTipped
 * @param name
 * @param status
 * @param updatedAt
 * @param updatedBy
 * @param venueID
 */
@Serializable
data class Role(
    @SerialName("Category")
    val category: String? = null,
    @SerialName("CreatedAt")
    val createdAt: Instant? = null,
    @SerialName("CreatedBy")
    val createdBy: ObjectID? = null,
    @SerialName("DefaultRoleID")
    val defaultRoleID: ObjectID? = null,
    @SerialName("DeletedAt")
    val deletedAt: Instant? = null,
    @SerialName("DeletedBy")
    val deletedBy: ObjectID? = null,
    @SerialName("Description")
    val description: String? = null,
    @SerialName("EmploymentConditions")
    val employmentConditions: List<EmploymentCondition>? = null,
    @SerialName("EmploymentConditionsHistory")
    val employmentConditionsHistory: List<EmploymentCondition>? = null,
    @SerialName("GroupID")
    val groupID: ObjectID? = null,
    @SerialName("ID")
    val id: ObjectID? = null,
    @SerialName("IsTipped")
    val isTipped: Boolean? = null,
    @SerialName("Name")
    val name: String? = null,
    @SerialName("Status")
    val status: String? = null,
    @SerialName("UpdatedAt")
    val updatedAt: Instant? = null,
    @SerialName("UpdatedBy")
    val updatedBy: ObjectID? = null,
    @SerialName("VenueID")
    val venueID: ObjectID? = null
)

