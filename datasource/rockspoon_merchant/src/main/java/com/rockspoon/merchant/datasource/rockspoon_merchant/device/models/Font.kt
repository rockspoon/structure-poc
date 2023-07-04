package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Font data transfer object
 *
 * @param default Default font size
 * @param defaultLarge Default large font size
 * @param large Large font size
 * @param medium Medium font size
 * @param small Small font size
 */
@Serializable
data class Font(
    /** Default font size */
    val default: Int? = null,
    /** Default large font size */
    val defaultLarge: Int? = null,
    /** Large font size */
    val large: Int? = null,
    /** Medium font size */
    val medium: Int? = null,
    /** Small font size */
    val small: Int? = null
)

