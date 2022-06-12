package com.example.poc.core.data.user

import com.example.poc.datasource.network.GitHubApiClient
import kotlinx.coroutines.delay


internal class UserNetworkDataSourceImpl(
    private val apiClient: GitHubApiClient
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

        delay(2000)

        users[user.id!!] = user
        return user
    }
}