package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * FeatureVersionConfig represents a feature version configuration
 *
 * @param featureId
 * @param id
 * @param permissionVersions
 */
@Serializable
data class FeatureVersionConfig(
    val featureId: String? = null,
    val id: String? = null,
    val permissionVersions: List<String>? = null
)

