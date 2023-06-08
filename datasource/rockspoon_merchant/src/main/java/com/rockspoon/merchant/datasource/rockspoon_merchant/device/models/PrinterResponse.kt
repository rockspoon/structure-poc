package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Printer data transfer object
 *
 * @param hardwareName Name of the hardware of that device
 * @param id Printer ID
 * @param ipAddress
 * @param mac
 * @param model Name of the model of the printer
 * @param name Name of the printer
 * @param code Generated printer code
 * @param serialNumber Serial Number
 * @param groups Printer groups
 * @param topics Printer topics
 * @param floorPlans floorplans to work with
 */
@Serializable
data class PrinterResponse(
    /** Name of the hardware of that device */
    val hardwareName: String? = null,
    /** Printer ID */
    val id: String? = null,
    val ipAddress: IP? = null,
    val mac: MAC? = null,
    /** Name of the model of the printer */
    val model: String? = null,
    /** Name of the printer */
    val name: String? = null,
    /** Generated printer code */
    val code: String? = null,
    /** Serial Number */
    val serialNumber: String? = null,
    /** Printer groups */
    val groups: List<String>? = null,
    /** Printer topics */
    val topics: List<Topic>? = null,
    /** floorplans to work with */
    val floorPlans: List<FloorPlan>? = null
)

