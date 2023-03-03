package com.example.poc.core.data.user

import kotlinx.coroutines.flow.Flow


// By having the REST API and database calls in data sources, I can, for example, just mock my
// remote data source returning whatever I want and I will not need to make calls to remote server
// and I still can test my logic implementation regarding the database synchronization, like in the
// insert method.
class UserRepositoryImpl(
    private val userDatabaseDataSource: UserDatabaseDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUser(id: Long): User? {

        // Always get user from database as it's our source of truth. If the data in the server
        // changes, a push notification should with the sync message should be send to the device
        // so it pull a new user and insert it in the database.
        return userDatabaseDataSource.getUser(id)
    }

    /**
     * Returns a coroutine Flow<core.data.User?> that observes changes in the
     * [androidx.room.Database].
     */
    override fun observeUser(id: Long): Flow<User?> {
        return userDatabaseDataSource.observeUser(id)
    }

    /**
     * Insert a User first in the remote sever, than in the device database, returning the entity.
     */
    override suspend fun insertUser(user: User): User {

        // Check conditions before any other code execution. Don't let just only the server do this
        if (user.id == null) throw UserRepository.UserIdNullException
        val passwordLength = user.password?.length ?: 0
        if (passwordLength < 8) throw UserRepository.UserPasswordShortException

        // Insert in the server, get the response...
        val remoteUser = userRemoteDataSource.insertUser(user)

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return userDatabaseDataSource.insertUser(remoteUser)
    }

    /**
     * A sync function that can be used by the sync service.
     */
    // TODO maybe this logic of syncing and etc should be in the use case. I need to review the
    // concerns of each. Nop, the suggestion by Android Team is this kind sync thing be here. This
    // simple app is so simple that the layers end up being redundant, but in more complete apps
    // the domain may contain complex functions like in a SignUpWithGoogleUseCase.
    override suspend fun syncUser(userId: Long): User {

        // Fetch in the server, get the response...
        val remoteUser = userRemoteDataSource.getUser(userId)
            ?: throw UserRepository.UserRemoteNotFoundException(userId)

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return userDatabaseDataSource.insertUser(remoteUser)
    }
}