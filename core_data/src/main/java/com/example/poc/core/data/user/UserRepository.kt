package com.example.poc.core.data.user

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUser(id: Long): User?

    fun observeUser(id: Long) : Flow<User?>

    suspend fun insertUser(user: User): User

    suspend fun syncUser(userId: Long): User

    class UserRemoteNotFoundException(id: Long) : RuntimeException("User with $id was not found in the remote sever.")

    object UserIdNullException : RuntimeException("User ID cannot be null.")

    object UserPasswordShortException :
        RuntimeException("User password provided is too short. It must be at least 8 characters long.")
}