package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * DeviceResponse data transfer object
 *
 * @param adminToken Admin Token
 * @param defaultPrinterId Default printer ID
 * @param device Device Android UUID
 * @param deviceId Device ID
 * @param externalId External ID
 * @param expiresIn Time until the token expires
 * @param group Group Name
 * @param name Device Name
 * @param preference
 * @param refreshToken Refresh token
 * @param tenantKey Tenant Key
 * @param apiKey Tenant API Key
 * @param type
 * @param venueId Venue ID
 */
@Serializable
data class DeviceResponse(
    /** Admin Token */
    val adminToken: String? = null,
    /** Default printer ID */
    val defaultPrinterId: String? = null,
    /** Device Android UUID */
    val device: String? = null,
    /** Device ID */
    val deviceId: String? = null,
    /** External ID */
    val externalId: String? = null,
    /** Time until the token expires */
    val expiresIn: String? = null,
    /** Group Name */
    val group: String? = null,
    /** Device Name */
    val name: String? = null,
    val preference: Preference? = null,
    /** Refresh token */
    val refreshToken: String? = null,
    /** Tenant Key */
    val tenantKey: String? = null,
    /** Tenant API Key */
    val apiKey: String? = null,
    val type: DeviceType? = null,
    /** Venue ID */
    val venueId: String? = null
)

