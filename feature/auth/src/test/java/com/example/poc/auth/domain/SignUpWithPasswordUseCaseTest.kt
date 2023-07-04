package com.example.poc.auth.domain

import com.example.poc.core.domain.base.UseCase
import com.example.poc.core.data.user.User
import com.example.poc.core.data.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SignUpWithPasswordUseCaseTest {

    /**
     * When repository throws user UserPasswordIsShortException signUpWithPasswordUseCase operator
     * invoke should return a Flow that emits a Result.Error with a UserPasswordTooShortException.
     */
    @Test
    fun whenRepositoryThrowsUserPasswordIsShort_signUpWithPasswordUseCase__shouldEmitUserPasswordTooShortException() =
        runBlocking {

            // When
            // TODO use mockito
            val fakeUserRepository = object : UserRepository {
                override suspend fun getUser(id: Long): User? = null
                override fun observeUser(id: Long): Flow<User?> {
                    TODO("Not yet implemented")
                }

                override suspend fun insertUser(user: User): User =
                    throw UserRepository.UserPasswordShortException

                override suspend fun syncUser(userId: Long): User {
                    TODO("Not yet implemented")
                }
            }

            val signUpWithPasswordUseCase = SignUpWithPasswordUseCase(
                coroutineDispatcher = Dispatchers.IO,
                userRepository = fakeUserRepository
            )

            // TODO use mockito
            val fakeUser = User()

            val firstEmission = signUpWithPasswordUseCase(
                parameters = SignUpWithPasswordUseCase.Params(fakeUser)
            ).first()
            val actualLoading = (firstEmission as UseCase.Result.Loading).progress
            Assert.assertEquals(-1, actualLoading)

            val secondEmission = signUpWithPasswordUseCase(
                parameters = SignUpWithPasswordUseCase.Params(fakeUser)
            ).last()
            val actualException = (secondEmission as UseCase.Result.Error).exception
            Assert.assertTrue(actualException is SignUpWithPasswordUseCase.UserPasswordTooShortException)
        }
}