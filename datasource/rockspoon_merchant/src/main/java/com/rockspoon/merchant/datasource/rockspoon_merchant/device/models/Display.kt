package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Display data transfer object
 *
 * @param alert
 * @param enableSound Flag to enable device sound
 * @param highlightSimilarItems Flag to highlight similar items
 * @param showReadyOrders Flag to show ready orders
 * @param slots Number of slots in the device
 */
@Serializable
data class Display(
    val alert: Alert? = null,
    /** Flag to enable device sound */
    val enableSound: Boolean? = null,
    /** Flag to highlight similar items */
    val highlightSimilarItems: Boolean? = null,
    /** Flag to show ready orders */
    val showReadyOrders: Boolean? = null,
    /** Number of slots in the device */
    val slots: Long? = null
)

