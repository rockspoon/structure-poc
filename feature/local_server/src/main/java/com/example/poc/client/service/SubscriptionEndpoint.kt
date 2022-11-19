package com.example.poc.client.service

import com.example.poc.client.data.Subscription
import com.example.poc.client.domain.SubscribeDataChangedUseCase
import com.example.poc.client.domain.UnsubscribeDataChangedUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * An endpoint for subscriptions of clients. Clients can subscribe for events by
 * providing an URL on the local network that a will be used as webhook for push
 * messages.
 */
class SubscriptionEndpoint(
    private val subscribeDataChangedUseCase: SubscribeDataChangedUseCase,
    private val unsubscribeDataChangedUseCase: UnsubscribeDataChangedUseCase
) : Route(
    parent = null,
    selector = RootRouteSelector("/subscription")
) {

    init {

        post {
            // TODO auth
            // TODO enforce subscription with webhook to the origin request URL
            // TODO handle errors
            val subscription = call.receive<Subscription>()
            this@SubscriptionEndpoint.subscribeDataChangedUseCase(subscription)
            call.respondText(
                text = "Subscribed correctly.",
                status = HttpStatusCode.Created
            )
        }

        delete("{id?}") {
            // TODO auth
            // TODO enforce un-subscription with webhook to the origin request URL
            // TODO handle errors
            val id = call.parameters["id"]?.toLong() ?: return@delete call.respond(
                HttpStatusCode.BadRequest
            )
            this@SubscriptionEndpoint.unsubscribeDataChangedUseCase(id)
            call.respondText(
                text = "Subscription removed correctly.",
                status = HttpStatusCode.Accepted
            )
        }

    }
}