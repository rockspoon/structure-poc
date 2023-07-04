package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/**
 * @param address
 * @param legalAddress
 */
@Serializable
data class UpdateAddressRequest(
    val address: AddressRequest,
    val legalAddress: AddressRequest
)

