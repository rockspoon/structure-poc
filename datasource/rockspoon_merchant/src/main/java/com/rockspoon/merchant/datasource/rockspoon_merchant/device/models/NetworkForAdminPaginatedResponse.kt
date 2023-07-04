package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Paginated response with NetworkForAdmin objects
 *
 * @param next Item id for next page
 * @param previous Item id for previous page
 * @param results
 * @param total
 */
@Serializable
data class NetworkForAdminPaginatedResponse(
    /** Item id for next page */
    val next: String? = null,
    /** Item id for previous page */
    val previous: String? = null,
    val results: List<NetworkForAdmin>? = null,
    val total: Long? = null
)

