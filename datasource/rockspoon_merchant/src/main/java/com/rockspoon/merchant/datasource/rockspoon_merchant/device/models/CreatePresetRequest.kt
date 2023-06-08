package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * CreatePresetRequest request
 *
 * @param adminToken Admin Token
 * @param expiresIn Time until the token expires
 * @param group Group Name
 * @param refreshToken Refresh token
 * @param apiKey api key
 * @param type
 * @param uuid QR Code
 * @param extendsDevice Flag to indicate if the device will be created as
 *     an extension
 */
@Serializable
data class CreatePresetRequest(
    /** Admin Token */
    val adminToken: String,
    /** Refresh token */
    val refreshToken: String,
    val type: DeviceType,
    /** QR Code */
    val uuid: String,
    /** Time until the token expires */
    val expiresIn: String? = null,
    /** Group Name */
    val group: String? = null,
    /** api key */
    val apiKey: String? = null,
    /** Flag to indicate if the device will be created as an extension */
    val extendsDevice: Boolean? = null
)

