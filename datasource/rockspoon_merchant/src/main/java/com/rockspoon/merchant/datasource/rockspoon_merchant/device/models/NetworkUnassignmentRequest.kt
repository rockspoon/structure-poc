package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Request to assign a router to a venue network. Either gatewayMacAddress
 * or serialNumber is required, with the latter taking precedence.
 *
 * @param venueId ID of the venue receiving the router
 * @param serialNumber Serial number of the router being assigned
 * @param gatewayMacAddress MAC address of the router
 */
@Serializable
data class NetworkUnassignmentRequest(
    /** ID of the venue receiving the router */
    val venueId: String? = null,
    /** Serial number of the router being assigned */
    val serialNumber: String? = null,
    /** MAC address of the router */
    val gatewayMacAddress: String? = null
)

