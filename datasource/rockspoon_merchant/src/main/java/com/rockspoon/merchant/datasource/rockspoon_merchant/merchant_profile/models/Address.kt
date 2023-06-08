package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * Address generic address model
 *
 * @param address1
 * @param address2
 * @param city
 * @param country Country in ISO 3166-1 alpha-3 format
 * @param instructions
 * @param latitude
 * @param longitude
 * @param name
 * @param region
 * @param state State in ISO 3166-2 format.
 * @param timezone
 * @param zipcode
 */
@Serializable
data class Address(
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    /** Country in ISO 3166-1 alpha-3 format */
    val country: String? = null,
    val instructions: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val name: String? = null,
    val region: String? = null,
    /** State in ISO 3166-2 format. */
    val state: String? = null,
    val timezone: String? = null,
    val zipcode: String? = null
)

