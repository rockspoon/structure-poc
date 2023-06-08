package com.rockspoon.merchant.datasource.rockspoon_merchant.orchestrator

import retrofit2.http.Header
import retrofit2.http.POST

interface OrchestratorApi {

    @POST("orchestrator/v1/device")
    suspend fun linkDeviceAndInstallApp(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("api_key") apiKey: String? = null,
        @Header("serial_number") serialNumber: String
    )
}