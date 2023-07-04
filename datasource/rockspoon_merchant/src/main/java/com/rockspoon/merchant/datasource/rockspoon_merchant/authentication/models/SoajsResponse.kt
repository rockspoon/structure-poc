package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models

import kotlinx.serialization.Serializable

/**
 * @param &#x60;data&#x60;
 * @param errors
 * @param result
 */
@Serializable
data class SoajsResponse(
    val data: Boolean? = null,
    val errors: Error? = null,
    val result: Boolean? = null
)

