package com.example.poc.auth.domain

import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.data.credentials.GetCredentialsRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.poc.core.domain.Result

/**
 * Makes the sign in of a new user.
 */
class SignInWithPasswordUseCase(
    private val credentialsRepository: CredentialsRepository
) {

    /**
     * Makes the sign in of a new user.
     *
     * @param email
     * @param password
     */
    operator fun invoke(email: String, password: String): Flow<Result<Unit>> = flow {
        emit(Result.Loading())
        try {
            val credentials = credentialsRepository.getCredentials(
                forceRefresh = true,
                request = GetCredentialsRequest.Email(email, password)
            )
            if (credentials != null) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error(InvalidEmailOrPasswordException))
            }

        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }

    object InvalidEmailOrPasswordException : RuntimeException("Invalid email or password.")
}