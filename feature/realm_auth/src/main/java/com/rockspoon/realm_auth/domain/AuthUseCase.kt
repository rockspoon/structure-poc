package com.rockspoon.realm_auth.domain

import com.example.poc.core.data.credentials.Credentials
import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthUseCase(
    private val credentialsRepository: CredentialsRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<AuthUseCase.Params, Credentials?>(coroutineDispatcher) {

    override fun execute(parameters: Params): Flow<UseCase.Result<Credentials?>> =
        flow {
            emit(UseCase.Result.Loading())
            emit(
                UseCase.Result.Success(
                    credentialsRepository.getCredentials(
                        true,
                        parameters.email,
                        parameters.password
                    )
                )
            )
        }

    data class Params(
        val email: String,
        val password: String,
    )
}