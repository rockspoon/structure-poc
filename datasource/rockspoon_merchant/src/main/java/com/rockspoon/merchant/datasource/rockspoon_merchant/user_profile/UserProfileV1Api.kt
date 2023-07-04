package com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile

import com.rockspoon.merchant.datasource.rockspoon_merchant.HEADER_ACCESS_TOKEN
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.UserRoleDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.UserDeviceSettingsDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.SendPaymentLinkRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.UpdateProfileInfoRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.UserProfileDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.common.PaginationResponseDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.ConsumerProfileDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.UserProfileSummaryDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.models.EmployeeRolesDto
import com.rockspoon.merchant.datasource.rockspoon_merchant.venue.VenueDto
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE = "user-profile/v1"

interface UserProfileV1Api {

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=getProfileByUserID">getProfileByUserID</a>
	 */
	@GET("$BASE/profile/me")
	suspend fun getUserProfile(): UserProfileDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=getProfileByID">getProfileByID</a>
	 */
	@GET("$BASE/profile/{id}")
	suspend fun getUserProfileById(
		@Header(HEADER_ACCESS_TOKEN) accessToken: String?,
		@Path("id") id: String
	): UserProfileDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=updateProfileContactInfo">updateProfileContactInfo</a>
	 */
	@PUT("$BASE/profile/{id}")
	suspend fun updateUserProfile(@Path("id") id: String, @Body request: UpdateProfileInfoRequest)

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=listVenuesByProfile">listVenuesByProfile</a>
	 */
	@GET("$BASE/profile/me/venue")
	suspend fun getUserVenues(@Header(HEADER_ACCESS_TOKEN) accessToken: String?): List<VenueDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=updateProfilePicture">updateProfilePicture</a>
	 */
	@Multipart
	@PUT("$BASE/profile/{id}/picture")
	suspend fun updateUserAvatar(@Path("id") id: String, @Part body: List<MultipartBody.Part>)

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=updateDeviceSettingsHandler">updateDeviceSettingsHandler</a>
	 */
	@PUT("$BASE/profile/settings")
	suspend fun updateUserDeviceSettings(@Body request: UserDeviceSettingsDto)

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=profilesByRoleIDs">profilesByRoleIDs</a>
	 */
	@GET("$BASE/profile")
	suspend fun getVenueUserProfileSummaries(): List<UserProfileSummaryDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=getRolesByVenueID">getRolesByVenueID</a>
	 */
	@GET("$BASE/role")
	suspend fun getUserRoles(): List<UserRoleDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=listRolesByRoleCategory">listRolesByRoleCategory</a>
	 */
	@GET("$BASE/role/digest")
	suspend fun getEmployeeRoles(): List<EmployeeRolesDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=consumerProfiles">consumerProfiles</a>
	 */
	@GET("$BASE/ca/profile")
	suspend fun getConsumers(
		@Query("pageSize") pageSize: Int,
		@Query("profileId") ids: List<String>
	): PaginationResponseDto<ConsumerProfileDto>

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=consumerProfileByID">consumerProfileByID</a>
	 */
	@GET("$BASE/ca/profile/{id}")
	suspend fun getConsumerById(@Path("id") profileId: String): ConsumerProfileDto

	/**
	 * @see <a href="https://main-cluster-stg.developer.azure-api.net/api-details#api=user-profile-v1&operation=notifyShadowUser">notifyShadowUser</a>
	 */
	@POST("$BASE/shadow-user/{shadowUserId}/notify")
	suspend fun sendPaymentLink(
		@Path("shadowUserId") shadowUserId: String,
		@Body contactInfo: SendPaymentLinkRequest
	)
}