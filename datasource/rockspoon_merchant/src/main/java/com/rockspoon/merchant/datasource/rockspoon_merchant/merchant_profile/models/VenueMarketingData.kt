package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.serialization.Serializable

/**
 * @param researcher
 * @param restaurantType
 * @param services
 * @param pos
 * @param usedApps
 * @param ownerInfo
 * @param reservations
 * @param ratingsCount
 * @param menuSize
 * @param primaryOwner
 * @param officerInfo
 * @param rate
 * @param email
 * @param website
 * @param ratings
 */
@Serializable
data class VenueMarketingData(
    val researcher: String? = null,
    val restaurantType: String? = null,
    val services: VenueMarketingDataServices? = null,
    val pos: String? = null,
    val usedApps: Map<String, String>? = null,
    val ownerInfo: VenueMarketingDataOwnerInfo? = null,
    val reservations: Boolean? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val ratingsCount: java.math.BigDecimal? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val menuSize: java.math.BigDecimal? = null,
    val primaryOwner: String? = null,
    val officerInfo: String? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val rate: java.math.BigDecimal? = null,
    val email: String? = null,
    val website: String? = null,
    val ratings: Map<String, Double>? = null
)

