package com.example.poc.client.domain

import com.example.poc.client.data.SubscriptionRepository

/**
 * Adds to a repository of subscriptions an client that wants to know about the changes of
 * an order.
 */
class UnsubscribeDataChangedUseCase(
    private val subscriptionRepository: SubscriptionRepository
) {

    suspend operator fun invoke(id: Long) {
        subscriptionRepository.deleteSubscription(id)
    }

}