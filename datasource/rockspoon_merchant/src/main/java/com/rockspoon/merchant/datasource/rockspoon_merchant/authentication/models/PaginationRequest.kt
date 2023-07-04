package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param next Next is the entry id which is used to find entry after it.
 * @param pageSize
 * @param previous Previous is the entry id which is used to find entry
 *     before it. If next is provided, then previous won't used.
 */
@Serializable
data class PaginationRequest(
    /** Next is the entry id which is used to find entry after it. */
    val next: String? = null,
    val pageSize: Long? = null,
    /**
     * Previous is the entry id which is used to find entry before it. If next
     * is provided, then previous won't used.
     */
    val previous: String? = null
)

