package com.example.poc.client.data

import kotlinx.coroutines.flow.Flow

// The implementation will use DataStore<Subscription>
interface SubscriptionRepository {

    suspend fun insertSubscription(subscription: Subscription)

    suspend fun deleteSubscription(id: Long)

    fun listSubscriptions(entityId: Long, entityType: Subscription.Type): Flow<Subscription>

}