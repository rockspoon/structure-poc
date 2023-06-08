package com.rockspoon.merchant.datasource.rockspoon_merchant.device.models

import kotlinx.serialization.Serializable

/**
 * device from with rockspoon app version
 *
 * @param name device vmware name
 * @param deviceCode vmware device id
 * @param appVersion Rockspoon POS version installed. If empty, the app is
 *     not installed in this device.
 */
@Serializable
data class DeviceWithAppVersion(
    /** device vmware name */
    val name: String? = null,
    /** vmware device id */
    val deviceCode: String? = null,
    /**
     * Rockspoon POS version installed. If empty, the app is not installed in
     * this device.
     */
    val appVersion: String? = null
)

