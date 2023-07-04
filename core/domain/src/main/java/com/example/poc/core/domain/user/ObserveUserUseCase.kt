package com.example.poc.core.domain.user

import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.data.user.User
import com.example.poc.core.data.user.UserRepository
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Use cases like this that are used by more than one module should be put here, in :core_domain.
class ObserveUserUseCase(
    private val userRepository: UserRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<ObserveUserUseCase.Params, User>(coroutineDispatcher) {

    override fun execute(parameters: Params): Flow<UseCase.Result<User>> = userRepository
        .observeUser(parameters.userId)
        .map {
            UseCase.Result.Success(data = it!!)
        }

    data class Params(
        val userId: Long
    )

    object UserNotFoundException : RuntimeException("")
}