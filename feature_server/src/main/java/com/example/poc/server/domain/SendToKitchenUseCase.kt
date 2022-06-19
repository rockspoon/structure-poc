package com.example.poc.server.domain

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository

class SendToKitchenUseCase(repository: OrderRepository) {

    operator fun invoke(order: Order) {
        // TODO Update order on repository

        // TODO Notify (push / publish) subscribers of this table change / event.
        //      We need the clients also to have a socket open for that or they will need to pull
        //      the notifications frequently, which is probably battery draining.

        // I will need here a repository with a proto DataStore to
    }
}