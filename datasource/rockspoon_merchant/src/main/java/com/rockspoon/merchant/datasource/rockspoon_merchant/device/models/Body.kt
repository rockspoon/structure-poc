package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/** @param defaultPrinterId Default printer id to be set as printer */
@Serializable
data class Body(
    /** Default printer id to be set as printer */
    val defaultPrinterId: String? = null
)

