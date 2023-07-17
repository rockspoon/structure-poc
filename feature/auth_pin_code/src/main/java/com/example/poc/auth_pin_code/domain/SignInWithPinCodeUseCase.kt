package com.example.poc.auth_pin_code.domain

import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.data.credentials.GetCredentialsRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.poc.core.domain.Result
import timber.log.Timber

/**
 * Makes the sign in of a new user.
 */
class SignInWithPinCodeUseCase(
    private val credentialsRepository: CredentialsRepository
) {

    /**
     * Makes the sign in of a new user.
     *
     * @param pinCode
     * @param key rockspoon venue api_key
     * @param deviceId rockspoon venue deivceId
     */
    operator fun invoke(pinCode: String, key: String, deviceId: String): Flow<Result<Unit>> = flow {
        emit(Result.Loading())
        try {
            val credentials = credentialsRepository.getCredentials(
                forceRefresh = true,
                request = GetCredentialsRequest.PinCode(pinCode = pinCode, key = key, deviceId = deviceId)
            )
            if (credentials != null) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error(InvalidParametersException))
            }

        } catch (e: Exception) {
            Timber.tag("SignInWithPinCodeUseCase").e(e)
            emit(Result.Error(e))
        }
    }

    object InvalidParametersException : RuntimeException("Invalid pincode or key or deviceId.")
}