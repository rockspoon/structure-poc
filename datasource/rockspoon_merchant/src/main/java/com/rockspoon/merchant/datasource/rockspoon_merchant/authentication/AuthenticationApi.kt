package com.rockspoon.merchant.datasource.rockspoon_merchant.authentication

import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.BoolResponse
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.LoginRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.PinLoginRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.PinRecoverRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.RefreshRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.SwitchContextToken
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.Token
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Rockspoon Authentication Microservice. The microservice is in charge of
 * user authentication (login, logout, PIN, change password, refresh token,
 * etc).
 */
interface AuthenticationApi {

    /** Authenticates user and generates access token. */
    @POST("authentication/v1/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Token

    /** Resends user pin. */
    @POST("authentication/v1/recovery/pin")
    suspend fun forgotPinByEmail(
        @Header("access_token") accessToken: String? = null,
        @Body pinRecoverRequest: PinRecoverRequest
    ): BoolResponse

    /** Authenticates user through his pin. */
    @POST("authentication/v1/user/pin")
    suspend fun pinLogin(
        @Header("deviceId") deviceId: String? = null,
        @Header("access_token") accessToken: String? = null,
        @Header("api_key") key: String? = null,
        @Body pinLoginRequest: PinLoginRequest
    ): Token

    /** Resends user pin by pin code. */
    @POST("authentication/v1/user/recovery/pin/reset")
    suspend fun pinReset(
        @Header("access_token") accessToken: String? = null,
        @Body pinRecoverRequest: PinRecoverRequest
    ): BoolResponse

    /**
     * Refreshes pin access token.
     *
     * @param noAccessToken set to true to do not add access token from the request
     * on CredentialsHeaderInjectorInterceptor.
     */
    @POST("authentication/v1/user/pin/refresh")
    suspend fun refreshPinToken(
        @Header("no_access_token") noAccessToken: Boolean? = null,
        @Header("key") key: String? = null,
        @Body refreshRequest: RefreshRequest
    ): Token

    /** Resends user pin. */
    @POST("authentication/v1/user/switch-role/{roleId}")
    suspend fun switchRole(
        @Header("access_token") accessToken: String? = null,
        @Header("key") key: String? = null,
        @Path("roleId") roleId: String
    ): SwitchContextToken
}