package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * OperatingEntityDTO represents DTO of operating entity model
 *
 * @param address
 * @param businessEntityId
 * @param name
 * @param phones
 * @param taxId
 * @param type
 */
@Serializable
data class OperatingEntityDTO(
    val address: Address? = null,
    val businessEntityId: String? = null,
    val name: String? = null,
    val phones: List<Phone>? = null,
    val taxId: String? = null,
    val type: EntityType? = null
)

