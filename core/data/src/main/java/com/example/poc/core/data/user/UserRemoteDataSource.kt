package com.example.poc.core.data.user

interface UserRemoteDataSource {
    suspend fun getUser(id: Long?): User
    suspend fun updateUser(user: User): User
    suspend fun insertUser(user: User): User
    suspend fun listUsers(
        name: String,
        profileIds: List<Long>,
        pageSize: Int,
        next: String,
        previous: String
    ): List<User>
}