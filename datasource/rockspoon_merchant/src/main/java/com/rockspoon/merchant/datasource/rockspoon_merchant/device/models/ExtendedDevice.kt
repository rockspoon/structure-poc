package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Extended device configuration
 *
 * @param batteryLevel Battery level of device
 * @param cardReaderBatteryLevel Battery level of card reader
 * @param cardReaderConnected Flag to check if a card reader is connected
 * @param deviceId Device ID
 * @param imei Device IMEI(International Mobile Equipment Identity)
 * @param index Device index for listing
 * @param name Device name
 * @param numberOfColumns Number of columns in device for display purposes
 * @param wifiNetwork Wifi network the device is connected to
 * @param wirelessSignal Wireless signal
 */
@Serializable
data class ExtendedDevice(
    /** Battery level of device */
    val batteryLevel: String? = null,
    /** Battery level of card reader */
    val cardReaderBatteryLevel: kotlin.Double? = null,
    /** Flag to check if a card reader is connected */
    val cardReaderConnected: Boolean? = null,
    /** Device ID */
    val deviceId: String? = null,
    /** Device IMEI(International Mobile Equipment Identity) */
    val imei: String? = null,
    /** Device index for listing */
    val index: Long? = null,
    /** Device name */
    val name: String? = null,
    /** Number of columns in device for display purposes */
    val numberOfColumns: Long? = null,
    /** Wifi network the device is connected to */
    val wifiNetwork: String? = null,
    /** Wireless signal */
    val wirelessSignal: String? = null
)

