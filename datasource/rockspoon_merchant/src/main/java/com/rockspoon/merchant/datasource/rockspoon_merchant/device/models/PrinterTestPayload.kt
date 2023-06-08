package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * printable test payload
 *
 * @param describeMessage
 * @param ipAddress
 * @param printPayload
 * @param printerModel
 */
@Serializable
data class PrinterTestPayload(
    val describeMessage: String? = null,
    val ipAddress: String? = null,
    val printPayload: String? = null,
    val printerModel: String? = null
)

