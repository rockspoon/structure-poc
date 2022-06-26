package com.example.poc.server.data

import kotlinx.coroutines.flow.Flow

interface SubscriptionDataSource {

    fun deleteSubscription(id: Long)

    fun insertSubscription(subscription: Subscription)

    fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription>

}