package com.example.poc.core.data.credentials

import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.LoginRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.PinLoginRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.RefreshRequest
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.models.Token
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CredentialsRemoteDataSourceImpl(
    private val authenticationApi: AuthenticationApi,
    private val ioDispatcher: CoroutineDispatcher
) : CredentialsRemoteDataSource {

    override suspend fun getCredentials(request: GetCredentialsRequest): Credentials =
        when (request) {
            is GetCredentialsRequest.Email -> getCredentials(request.email, request.password)
            is GetCredentialsRequest.PinCode -> getCredentialsByPinCode(request.pinCode, request.key, request.deviceId)
        }

    private suspend fun getCredentials(email: String, password: String): Credentials =
        withContext(ioDispatcher) {
            authenticationApi.login(
                loginRequest = LoginRequest(
                    username = email,
                    password = password
                )
            ).toModel()
        }

    private suspend fun getCredentialsByPinCode(pinCode: String, key: String, deviceId: String): Credentials =
        withContext(ioDispatcher) {
            authenticationApi.pinLogin(
                key = key,
                deviceId = deviceId,
                pinLoginRequest = PinLoginRequest(
                    pin = pinCode
                )
            ).toModel()
        }

    override suspend fun updateCredentials(refreshToken: String): Credentials =
        withContext(ioDispatcher) {
            authenticationApi.refreshPinToken(
                noAccessToken = true,
                refreshRequest = RefreshRequest(
                    refreshToken = refreshToken
                )
            ).toModel()
        }

    private fun Token.toModel() = Credentials(
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}