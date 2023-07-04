package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param phone
 * @param tablet
 */
@Serializable
data class TypefaceSettings(
    val phone: TypefaceType? = null,
    val tablet: TypefaceType? = null
)

