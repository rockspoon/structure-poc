package com.example.poc.server.data

import kotlinx.coroutines.flow.Flow

interface SubscriptionDataSource {

    suspend fun deleteSubscription(id: Long)

    suspend fun insertSubscription(subscription: Subscription)

    fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription>

}