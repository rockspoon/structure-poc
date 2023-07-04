package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * AdvanceNotice represents advance notice model
 *
 * @param unit
 * @param value
 */
@Serializable
data class AdvanceNotice(
    val unit: AdvanceNoticeUnit? = null,
    val value: Long? = null
)

