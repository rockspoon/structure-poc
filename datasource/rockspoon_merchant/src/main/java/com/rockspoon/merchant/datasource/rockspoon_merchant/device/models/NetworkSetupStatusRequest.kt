package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Request telling if network setup was successful
 *
 * @param venueId ID of the venue
 * @param connectionResult Setup result
 * @param gatewayMacAddress MAC address of the router
 */
@Serializable
data class NetworkSetupStatusRequest(
    /** ID of the venue */
    val venueId: String,
    /** Setup result */
    val connectionResult: Boolean,
    /** MAC address of the router */
    val gatewayMacAddress: String? = null
)

