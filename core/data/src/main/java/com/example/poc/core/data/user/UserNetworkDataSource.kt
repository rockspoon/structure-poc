package com.example.poc.core.data.user

interface UserNetworkDataSource {
    suspend fun getUser(id: Long): User?
    suspend fun insertUser(user: User): User
}