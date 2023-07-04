package com.example.poc.client.data

import kotlinx.coroutines.flow.Flow

class SubscriptionRepositoryImpl(
    private val subscriptionDataSource: SubscriptionDataSource
) : SubscriptionRepository {

    override suspend fun insertSubscription(subscription: Subscription) {
        subscriptionDataSource.insertSubscription(subscription)
    }

    override suspend fun deleteSubscription(id: Long) {
        subscriptionDataSource.deleteSubscription(id)
    }

    override fun listSubscriptions(entityId: Long, entityType: Subscription.Type): Flow<Subscription> {
        return subscriptionDataSource.listSubscriptions(entityId, entityType)
    }

}