package com.example.poc.core.data.user

import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient


internal class UserRemoteDataSourceImpl(
    private val apiClient: RemoteClientApiClient
) : UserRemoteDataSource {

    private val items: MutableList<User> = INITIAL_ITEMS.toMutableList()

    override suspend fun getUser(id: Long?): User {
        return if (id == null) items.first()
        else items.find { it.id == id }!!
    }

    override suspend fun updateUser(user: User): User {
        val oldItem = items.find { it.id == user.id }
        val index = items.indexOf(oldItem)
        items.remove(oldItem)
        items.add(index, user)
        return user
    }

    override suspend fun insertUser(user: User): User {
        items.add(user)
        return user
    }

    override suspend fun listUsers(
        name: String,
        profileIds: List<Long>,
        pageSize: Int,
        next: String,
        previous: String
    ): List<User> {
        return items.filter { profileIds.contains(it.id) }.take(pageSize)
    }

    companion object {
        val INITIAL_ITEMS = listOf(
            User(
                id = 1,
                givenName = "Adam",
                familyName = "Smith",
                email = "adam.smith@example.com"
            ),
            User(
                id = 2,
                givenName = "Jacques",
                familyName = "Cousteau",
                email = "jacques.cousteau@example.com"
            ),
            User(
                id = 3,
                givenName = "Ernest",
                familyName = "Hemingway",
                email = "ernest.hemingway@example.com"
            )
        )
    }
}