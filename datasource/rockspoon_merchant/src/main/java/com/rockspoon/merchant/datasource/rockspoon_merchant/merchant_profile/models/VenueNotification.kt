package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * VenueNotification represents venue notification struct
 *
 * @param resources
 * @param type
 * @param value
 */
@Serializable
data class VenueNotification(
    val resources: List<ResourceType>? = null,
    val type: SubscriberType? = null,
    val value: String? = null
)

