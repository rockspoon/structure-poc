package com.example.poc.client.service

import com.example.poc.client.data.Message
import com.example.poc.client.domain.SyncOrderUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * An endpoint for the push handlers on a local network that will be using to subscribe
 * the application acting as a client. The message received here will always be a sync
 * request, but the entity type may vary.
 */
class SyncEndpoint(
    private val syncOrderUseCase: SyncOrderUseCase,
) : Route(
    parent = null,
    selector = RootRouteSelector("/sync")
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

            // Invoke request sync
            val message = call.receive<Message>()
            when (message.entityType) {
                Message.Type.ORDER -> {
                    // I can request a sync service and the sync service call syncOrderUseCase.
                    this@SyncEndpoint.syncOrderUseCase(parameters = message.entityId)
                }
            }

            call.respondText(
                text = "Message received.",
                status = HttpStatusCode.Created
            )
        }

    }
}