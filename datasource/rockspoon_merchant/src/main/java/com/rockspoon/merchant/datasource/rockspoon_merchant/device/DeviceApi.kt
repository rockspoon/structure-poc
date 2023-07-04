package com.rockspoon.merchant.datasource.rockspoon_merchant.device

import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.ConsumePresetRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.CreateDeviceRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.CreateGroupRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.CreatePresetRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.DeviceResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.Groups
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.ID
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.StatusReportRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.StockRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.models.StockResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface DeviceApi {

    @GET("device/v1/me")
    suspend fun meDevice(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String
    ): DeviceResponse

    @PATCH("device/v1/me")
    suspend fun meDevicePatch(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String,
        @Body body: com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.models.Body
    )

    @POST("device/v1/register-qrcode")
    suspend fun provisionByQRCode(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Body body: CreatePresetRequest
    )

    @POST("device/v1/redeem-qrcode")
    suspend fun createByQRCode(
        @Header("key") key: String? = null,
        @Body body: ConsumePresetRequest
    ): DeviceResponse

    @POST("device/v1/")
    suspend fun postDevice(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Body body: List<CreateDeviceRequest>
    ): ID

    @POST("device/v1/status")
    suspend fun postStatus(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String,
        @Body body: StatusReportRequest
    ): ID

    @DELETE("device/v1/{deviceId}/extension")
    suspend fun removeExtension(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String
    )

    @GET("device/v1/kitchen/show-screen-sequence")
    suspend fun showScreenSequence(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String
    )

    @GET("device/v1/group")
    suspend fun getGroups(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
    ): Groups

    @POST("device/v1/group")
    suspend fun postGroup(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Body body: CreateGroupRequest
    )

    /** Creates a new stock devices. */
    @POST("device/v1/stock")
    suspend fun postStockDevice(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Body body: StockRequest
    ): StockResponse
}