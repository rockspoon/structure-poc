package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address1
 * @param address2
 * @param city
 * @param country Country in ISO 3166-1 alpha-3 format
 * @param name
 * @param region
 * @param state State in ISO 3166-2 format.
 * @param timezone
 * @param zipcode
 */
@Serializable
data class AddressRequest(
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    /** Country in ISO 3166-1 alpha-3 format */
    val country: String? = null,
    val name: String? = null,
    val region: String? = null,
    /** State in ISO 3166-2 format. */
    val state: String? = null,
    val timezone: String? = null,
    val zipcode: String? = null
)

