package com.example.poc.core.data.user

import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient
import kotlinx.coroutines.delay


internal class UserNetworkDataSourceImpl(
    private val apiClient: RemoteClientApiClient
) : UserNetworkDataSource {

    // Mock a server
    private val users = mutableMapOf<Long, User>()

    override suspend fun getUser(id: Long): User? {
        delay(1000)
        return users[id]
    }

    override suspend fun insertUser(user: User): User {
        if (user.id == null) throw UserRepository.UserIdNullException

        val password = user.password?.length ?: 0
        if (password < 8) throw UserRepository.UserPasswordShortException

        delay(3000)

        users[user.id!!] = user
        return user
    }
}