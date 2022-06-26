package com.example.poc.server.data

import kotlinx.coroutines.flow.Flow

// The implementation will use DataStore<Subscription>
interface SubscriptionRepository {

    fun insertSubscription(subscription: Subscription)

    fun deleteSubscription(id: Long)

    fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription>

}