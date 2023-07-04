package com.example.poc.domain

import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CheckUserIsLoggedInUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val credentialsRepository: CredentialsRepository
) : FlowUseCase<Unit, Boolean>(coroutineDispatcher) {

    override fun execute(parameters: Unit): Flow<UseCase.Result<Boolean>> {
        return flow {
            emit(UseCase.Result.Loading())
            emit(UseCase.Result.Success(credentialsRepository.getCredentials(forceRefresh = true) != null))
        }
    }
}
