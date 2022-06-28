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

        post {
            // TODO auth
            // TODO enforce subscription with webhook to the origin request URL
            // TODO handle errors
            val message = call.receive<Message>()
            this@MessageEndpoint.notifyDataChangedUseCase(message)
            call.respondText(
                text = "Message received.",
                status = HttpStatusCode.Created
            )
        }

    }
}