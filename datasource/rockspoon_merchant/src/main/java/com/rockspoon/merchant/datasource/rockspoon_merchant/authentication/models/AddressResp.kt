package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * AddressResp generic address model
 *
 * @param address1
 * @param address2
 * @param city
 * @param country
 * @param id
 * @param instructions
 * @param isDefault
 * @param isValidated
 * @param latitude
 * @param longitude
 * @param name
 * @param region
 * @param state
 * @param status
 * @param timezone
 * @param zipcode
 */
@Serializable
data class AddressResp(
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    val country: String? = null,
    val id: String? = null,
    val instructions: String? = null,
    val isDefault: Boolean? = null,
    val isValidated: Boolean? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val name: String? = null,
    val region: String? = null,
    val state: String? = null,
    val status: String? = null,
    val timezone: String? = null,
    val zipcode: String? = null
)

