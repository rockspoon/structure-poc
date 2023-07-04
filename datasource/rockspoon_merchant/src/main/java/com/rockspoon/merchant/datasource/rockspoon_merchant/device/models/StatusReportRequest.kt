package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * Status Report for device
 *
 * @param androidVersionRelease Android Version
 * @param availableCpuPercentage Amount of CPU available
 * @param availableExternalMemorySize Amount of external memory available
 * @param availableInternalMemorySize Amount of internal memory available
 * @param availableMemoryMB Total available memory
 * @param batteryHealth Status of the battery health
 * @param batteryLevel Battery level
 * @param batteryTemp Battery temperature
 * @param bluetoothError Bluetooth error
 * @param bluetoothIsOk Flag to check if bluetooth is ok
 * @param buildVersion Build version
 * @param cardReaderBatteryLevel Card reader battery level
 * @param cardReaderConnected Flag to check if a card reader is connected
 * @param cellularNetwork Celular network of the device
 * @param cellularSignal Celular signal
 * @param deviceName Device name
 * @param deviceType
 * @param deviceUniqueId Device unique ID
 * @param hardwareModel Hardware Model
 * @param manufacturer Manufacturer
 * @param powerStatus Power status
 * @param sdkVersion SDK version
 * @param totalExternalMemorySize Total external memory
 * @param totalInternalMemorySize Total internal memory
 * @param totalMemoryMB Total memory
 * @param updateTime Update time
 * @param userLanguage User language
 * @param version Version
 * @param versionCode Version Code
 * @param wifiNetwork Wifi network name
 * @param wirelessSignal Wireless signal
 * @param wirelessSpeed Wireless speed
 */
@Serializable
data class StatusReportRequest(
    /** Android Version */
    val androidVersionRelease: String? = null,
    /** Amount of CPU available */
    val availableCpuPercentage: Long? = null,
    /** Amount of external memory available */
    val availableExternalMemorySize: Long? = null,
    /** Amount of internal memory available */
    val availableInternalMemorySize: Long? = null,
    /** Total available memory */
    val availableMemoryMB: Long? = null,
    /** Status of the battery health */
    val batteryHealth: String? = null,
    /** Battery level */
    val batteryLevel: kotlin.Double? = null,
    /** Battery temperature */
    val batteryTemp: kotlin.Double? = null,
    /** Bluetooth error */
    val bluetoothError: String? = null,
    /** Flag to check if bluetooth is ok */
    val bluetoothIsOk: Boolean? = null,
    /** Build version */
    val buildVersion: String? = null,
    /** Card reader battery level */
    val cardReaderBatteryLevel: kotlin.Double? = null,
    /** Flag to check if a card reader is connected */
    val cardReaderConnected: Boolean? = null,
    /** Celular network of the device */
    val cellularNetwork: String? = null,
    /** Celular signal */
    val cellularSignal: kotlin.Double? = null,
    /** Device name */
    val deviceName: String? = null,
    val deviceType: DeviceType? = null,
    /** Device unique ID */
    val deviceUniqueId: String? = null,
    /** Hardware Model */
    val hardwareModel: String? = null,
    /** Manufacturer */
    val manufacturer: String? = null,
    /** Power status */
    val powerStatus: String? = null,
    /** SDK version */
    val sdkVersion: Long? = null,
    /** Total external memory */
    val totalExternalMemorySize: Long? = null,
    /** Total internal memory */
    val totalInternalMemorySize: Long? = null,
    /** Total memory */
    val totalMemoryMB: Long? = null,
    /** Update time */
    val updateTime: Long? = null,
    /** User language */
    val userLanguage: String? = null,
    /** Version */
    val version: String? = null,
    /** Version Code */
    val versionCode: Long? = null,
    /** Wifi network name */
    val wifiNetwork: String? = null,
    /** Wireless signal */
    val wirelessSignal: kotlin.Double? = null,
    /** Wireless speed */
    val wirelessSpeed: kotlin.Double? = null
)

