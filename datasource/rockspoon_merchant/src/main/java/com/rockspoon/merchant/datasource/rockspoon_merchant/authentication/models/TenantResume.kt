package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param code
 * @param id
 * @param venueID
 */
@Serializable
data class TenantResume(
    val address: Address? = null,
    val code: String? = null,
    val id: String? = null,
    val venueID: String? = null
)

