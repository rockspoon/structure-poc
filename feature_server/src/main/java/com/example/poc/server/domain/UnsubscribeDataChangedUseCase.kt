package com.example.poc.server.domain

import com.example.poc.server.data.Subscription
import com.example.poc.server.data.SubscriptionRepository

/**
 * Adds to a repository of subscriptions an client that wants to know about the changes of
 * an order.
 */
class UnsubscribeDataChangedUseCase(
    private val subscriptionRepository: SubscriptionRepository
) {

    operator fun invoke(id: Long) {
        subscriptionRepository.deleteSubscription(id)
    }

}