package com.example.poc.server.data

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow

// Need to create a module :datasource_serverdatastore
class SubscriptionDataSourceImpl(
    private val subscriptionDataStore: DataStore<Subscription>
) : SubscriptionDataSource {

    override fun deleteSubscription(id: Long) {
        TODO("Not yet implemented")
    }

    override fun insertSubscription(subscription: Subscription) {
        TODO("Not yet implemented")
    }

    override fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription> =
        subscriptionDataStore.data

}