package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Response when a printer is created
 *
 * @param id ID
 * @param name Set or automatically generated name for the printer
 */
@Serializable
data class CreatePrinterResponse(
    /** ID */
    val id: String? = null,
    /** Set or automatically generated name for the printer */
    val name: String? = null
)

