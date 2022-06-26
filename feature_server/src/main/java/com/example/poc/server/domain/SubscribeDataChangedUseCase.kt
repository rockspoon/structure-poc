package com.example.poc.server.domain

import com.example.poc.server.data.Subscription
import com.example.poc.server.data.SubscriptionRepository

/**
 * Adds to a repository of subscriptions an client that wants to know about the changes of
 * an order.
 */
class SubscribeDataChangedUseCase(
    private val subscriptionRepository: SubscriptionRepository
) {

    operator fun invoke(subscription: Subscription) {
        subscriptionRepository.insertSubscription(subscription)
    }

}