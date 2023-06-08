package com.rockspoon.merchant.datasource.rockspoon_merchant.checkin

import com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.models.BeaconResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.models.GetCheckInVenueListResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.models.UpdateStatus
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Query

interface CheckInApi {

    @GET("checkin/v1/beacon")
    suspend fun getActiveBeacon(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Header("deviceId") deviceId: String
    ): BeaconResponse

    @GET("checkin/v1/")
    suspend fun getCheckIn(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Query("next") next: String?,
        @Query("previous") previous: String?,
        @Query("pageSize") pageSize: Int?,
        @Query("deviceId") deviceId: String?,
        @Query("isDeleted") isDeleted: Boolean? = false,
        @Query("isInactive") isInactive: Boolean? = false
    ): GetCheckInVenueListResponse

    @PUT("checkin/v1/status")
    suspend fun putStatus(
        @Body request: UpdateStatus
    )
}
