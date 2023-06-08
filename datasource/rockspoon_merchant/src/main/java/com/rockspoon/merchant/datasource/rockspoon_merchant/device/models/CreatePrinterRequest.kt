package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * CreatePrinterRequest request
 *
 * @param groups Array of groups for the printer
 * @param hardwareName Name of the hardware of that device
 * @param ipAddress
 * @param mac
 * @param model Name of the model of the printer
 * @param network
 * @param serialNumber Serial Number
 * @param topics Array of topics of the printer
 * @param name Custom printer name
 * @param floorPlans floorplans to work with
 */
@Serializable
data class CreatePrinterRequest(
    /** Name of the hardware of that device */
    val hardwareName: String,
    val ipAddress: IP,
    val mac: MAC,
    /** Name of the model of the printer */
    val model: String,
    /** Array of groups for the printer */
    val groups: List<String>? = null,
    val network: CreateNetworkRequest? = null,
    /** Serial Number */
    val serialNumber: String? = null,
    /** Array of topics of the printer */
    val topics: List<Topic>? = null,
    /** Custom printer name */
    val name: String? = null,
    /** floorplans to work with */
    val floorPlans: List<FloorPlan>? = null
)

