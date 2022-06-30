package com.example.poc.client.service

import com.example.poc.client.data.Message
import com.example.poc.client.domain.NotifyDataChangedUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * An endpoint for the push handlers on a local network that will be using to subscribe
 * the application acting as a client.
 */
class MessageEndpoint(
    private val notifyDataChangedUseCase: NotifyDataChangedUseCase,
) : Route(
    parent = null,
    selector = RootRouteSelector("/push")
) {

    init {

        // TODO I should request Sync service from here, and sync service should call
        //  syncLocalOrderUseCase which would call repository sync local order.
        //      Now I will have to define how to store a local order.
        // TODO feature_client needs a client
        post {
            // TODO auth
            // TODO enforce subscription with webhook to the origin request URL
            // TODO handle errors

            val message = call.receive<Message>()

            // TODO invoke request sync

            call.respondText(
                text = "Message received.",
                status = HttpStatusCode.Created
            )
        }

    }
}