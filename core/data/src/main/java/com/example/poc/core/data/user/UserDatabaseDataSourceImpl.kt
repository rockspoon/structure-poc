package com.example.poc.core.data.user

import com.example.poc.datasource.database.Database
import com.example.poc.datasource.database.user.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


// Using data sources directly is forbidden with the keyword `internal` so to do not overpass our
// sync logic between database and remote data as written in the repository. The interfaces can
// still be mocked for testing though.
internal class UserDatabaseDataSourceImpl(
    private val database: Database
) : UserDatabaseDataSource {

    override suspend fun getUser(id: Long): User {
        return database.userDao().get(id).toModel()
    }

    override fun observeUser(id: Long): Flow<User?> {
        // Add here a call to Database that returns a Flow so we can observe changes to the "user"
        // database table. Notice that we just need to map the entity to model because Room has
        // first class support for coroutines. In case a library do not return coroutines Flow
        // directly, we would have to create a flow using the `callbackFlow { }` builder to map
        // their callbacks to flow emissions.
        return database.userDao().observe(id).map {
            it.toModel()
        }
    }

    override suspend fun insertUser(
        user: User
    ): User {
        if (user.id == null) throw UserRepository.UserIdNullException

        // Should we check this again here? Or choose a single layer to make the check and
        // sanitation of data? Data sources are sometimes accessed without the Repository, so here
        // it's possible a good place
        val passwordLength = user.password?.length ?: 0
        if (passwordLength < 8) throw UserRepository.UserPasswordShortException

        val entity = user.toEntity()
        val id = database.userDao().insert(entity)
        return database.userDao().get(id).toModel()
    }

    private fun UserEntity.toModel() =
        User(
            id = id,
            email = email,
            givenName = "",
            familyName = ""
        )

    private fun User.toEntity() =
        UserEntity(
            id = this.id,
            email = email
        )
}