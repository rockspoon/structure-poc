package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile

import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.CapacityConfig
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.DeviceSetupResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.GiftCardOptionsResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.HolidayResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.SellingInformationResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.VenueAvailabilityDTO
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models.VenuePublicInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface MerchantProfileApi {

    @GET("merchant-profile/v2/venue/{id}")
    suspend fun getVenueInformation(
        @Path("id") id: String
    ): VenuePublicInfo

    @GET("merchant-profile/v2/venue/selling-information")
    suspend fun getSellingInformation(): SellingInformationResponse

    @GET("merchant-profile/v2/venue/capacity/delivery")
    suspend fun deliveryCapacityByID(): CapacityConfig

    @GET("merchant-profile/v2/venue/capacity/kitchen-output")
    suspend fun kitchenOutputCapacityByID(): CapacityConfig

    @GET("merchant-profile/v2/venue/gift-card-information")
    suspend fun getGiftCardOptions(): GiftCardOptionsResponse

    @GET("merchant-profile/v2/venue/opening-hours")
    suspend fun getOpeningHours(): VenueAvailabilityDTO

    @GET("merchant-profile/v2/venue/holiday")
    suspend fun listHolidays(): List<HolidayResponse>

    @GET("merchant-profile/v2/venue/device-setup")
    suspend fun getDeviceSetupInfo(): DeviceSetupResponse
}
