package com.example.poc.auth.domain

import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Makes the sign in of a new user.
 */
class SignInWithPasswordUseCase(
    private val credentialsRepository: CredentialsRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<SignInWithPasswordUseCase.Params, Unit>(coroutineDispatcher) {

    /**
     * Makes the sign in of a new user.
     *
     * @param email
     * @param password
     */
    override fun execute(parameters: SignInWithPasswordUseCase.Params): Flow<UseCase.Result<Unit>> =
        flow {
            emit(UseCase.Result.Loading())
            try {
                val credentials = credentialsRepository.getCredentials(
                    forceRefresh = true,
                    email = parameters.email,
                    password = parameters.password
                )
                if (credentials != null) {
                    emit(UseCase.Result.Success(Unit))
                } else {
                    emit(UseCase.Result.Error(InvalidEmailOrPasswordException))
                }

            } catch (e: Exception) {
                emit(UseCase.Result.Error(e))
            }
        }

    data class Params(
        val email: String?,
        val password: String?
    )

    object InvalidEmailOrPasswordException : RuntimeException("Invalid email or password.")
}