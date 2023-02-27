package com.rockspoon.test.data.user

import com.rockspoon.merchant.core.data.common.Phone
import com.rockspoon.merchant.core.data.user.User
import com.rockspoon.merchant.core.data.user.UserRemoteDataSource

class TestUserRemoteDataSource(
    private val initialItems: List<User> = INITIAL_ITEMS
) : UserRemoteDataSource {

    private val items: MutableList<User> = initialItems.toMutableList()

    override suspend fun getUser(id: String?): User {
        return if (id == null) initialItems.first()
        else initialItems.find { it.id == id }!!
    }

    override suspend fun updateUser(user: User): User {
        val oldItem = items.find { it.id == user.id }
        val index = items.indexOf(oldItem)
        items.remove(oldItem)
        items.add(index, user)
        return user
    }

    override suspend fun listUsers(
        name: String,
        profileIds: List<String>,
        pageSize: Int,
        next: String,
        previous: String
    ): List<User> {
        return initialItems.filter { profileIds.contains(it.id) }.take(pageSize)
    }

    companion object {
        val INITIAL_ITEMS = listOf(
            User(
                id = "1",
                firstName = "Adam",
                lastName = "Smith",
                phone = Phone("44", "01632960028"),
                email = "adam.smith@example.com"
            ),
            User(
                id = "2",
                firstName = "Jacques",
                lastName = "Cousteau",
                phone = Phone("33", "934313992"),
                email = "jacques.cousteau@example.com"
            ),
            User(
                id = "3",
                firstName = "Ernest",
                lastName = "Hemingway",
                phone = Phone("1", "2025550105"),
                email = "ernest.hemingway@example.com"
            )
        )
    }
}