package com.example.poc.auth.domain

import com.example.poc.auth.domain.SignUpWithPasswordUseCase.*
import com.example.poc.core.data.user.User
import com.example.poc.core.data.user.UserRepository
import com.example.poc.core.domain.base.FlowUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *
 * Makes the sign up of a new user.
 *
 * @throws UserInsertionException
 * @throws UserIdNotValidException
 * @throws UserPasswordTooShortException
 */
class SignUpWithPasswordUseCase(
    private val userRepository: UserRepository,
    coroutineDispatcher: CoroutineDispatcher
) : FlowUseCase<Params, User>(coroutineDispatcher) {

    override fun execute(parameters: Params): Flow<UseCase.Result<User>> = flow {
        emit(UseCase.Result.Loading())
        try {
            val user = userRepository.insertUser(parameters.user)

            emit(UseCase.Result.Success(user))

        } catch (e: UserRepository.UserIdNullException) {

            emit(UseCase.Result.Error(UserIdNotValidException(id = parameters.user.id)))

        } catch (e: UserRepository.UserPasswordShortException) {

            emit(UseCase.Result.Error(UserPasswordTooShortException))

        } catch (e: Exception) {

            emit(UseCase.Result.Error(e))
        }
    }

    data class Params(
        val user: User
    )

    open class UserInsertionException(override val message: String?) : RuntimeException(message)

    class UserIdNotValidException(id: Long?) :
        UserInsertionException("User insertion with $id failed. Check if ID provided is valid.")

    object UserPasswordTooShortException :
        UserInsertionException("User insertion failed. Password provided is must be at least 8 characters long.")

}