package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * CreateGroup request structure
 *
 * @param groups Groups Names
 */
@Serializable
data class CreateGroupRequest(
    /** Groups Names */
    val groups: List<String>
)

