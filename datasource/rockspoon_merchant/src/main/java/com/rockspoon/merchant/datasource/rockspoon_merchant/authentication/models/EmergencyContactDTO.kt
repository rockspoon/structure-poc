package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param firstName
 * @param lastName
 * @param phone
 */
@Serializable
data class EmergencyContactDTO(
    val firstName: String? = null,
    val lastName: String? = null,
    val phone: Phone? = null
)

