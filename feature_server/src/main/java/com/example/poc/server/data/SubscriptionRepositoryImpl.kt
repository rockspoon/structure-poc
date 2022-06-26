package com.example.poc.server.data

import kotlinx.coroutines.flow.Flow

class SubscriptionRepositoryImpl(
    private val subscriptionDataSource: SubscriptionDataSource
): SubscriptionRepository {

    override fun insertSubscription(subscription: Subscription) {
        subscriptionDataSource.insertSubscription(subscription)
    }

    override fun deleteSubscription(id: Long) {
        subscriptionDataSource.deleteSubscription(id)
    }

    override fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription> {
        return subscriptionDataSource.listSubscriptions(entityId, entityType)
    }

}