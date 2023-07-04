package com.example.poc.client.service

import android.util.Log
import com.example.poc.client.data.Order
import com.example.poc.client.domain.GetOrderUseCase
import com.example.poc.client.domain.InsertOrderUseCase
import com.example.poc.client.domain.SendOrderToKitchenUseCase
import com.example.poc.client.domain.SendOrderToKitchenUseCase.NonOpenOrderSentToKitchenException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * An endpoint for Orders resources.
 */
// Concerns to the endpoint authentication, call the appropriate UseCase, and
// handle errors.
class OrderEndpoint(
    private val getOrderUseCase: GetOrderUseCase,
    private val insertOrderUseCase: InsertOrderUseCase,
    private val sendOrderToKitchenUseCase: SendOrderToKitchenUseCase,
) : Route(
    parent = null,
    selector = RootRouteSelector("/order")
) {

    init {
        get("{id?}") {
            val id = call.parameters["id"]?.toLong() ?: return@get call.respondText(
                text = "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val order = this@OrderEndpoint.getOrderUseCase(id)
            call.respond(order)
        }

        post {
            val order = call.receive<Order>()
            this@OrderEndpoint.insertOrderUseCase(order)
            call.respondText(
                text = "Order stored correctly",
                status = HttpStatusCode.Created
            )
        }

        // We are implement a REST API, so instead of call a remote procedure (RPC)
        // we update a resource with the desired value. The server is responsible
        // to verify if the client has the appropriate permission.

        // Note that the body object do not need to have all the parameters, only the
        // the ones that it can per documentation modify. The others are ignored.

        // We let id here nullable to give a custom error message. If it was
        // non null the body would be even called and instead a Ktor would call it.
        put("{id?}") {
            try {
                val body = call.receive<Order>()
                val orderId = call.parameters["id"]?.toLong() ?: return@put call.respondText(
                    text = "Order ID provided was null. Order should have a valid non-null ID.",
                    status = HttpStatusCode.BadRequest
                )

                val orderUpdated = when (body.status) {
                    Order.Status.OPEN -> {
                        // Not sure if order should be re-opened.
                        TODO()
                    }
                    Order.Status.PREPARING -> {
                        this@OrderEndpoint.sendOrderToKitchenUseCase(orderId)
                    }
                    Order.Status.CANCELLED -> TODO()
                    Order.Status.READY -> TODO()
                    Order.Status.IN_TRANSIT -> TODO()
                    Order.Status.DELIVERED -> TODO()
                    Order.Status.RETURNED -> TODO()
                }

                call.respond(orderUpdated)

            } catch (e: NonOpenOrderSentToKitchenException) {
                call.respondText(
                    text = e.message.orEmpty(),
                    status = HttpStatusCode.BadRequest
                )
            } catch (e: Exception) {
                call.respondText(
                    text = e.message.orEmpty(),
                    status = HttpStatusCode.InternalServerError
                )
                Log.e("OrderEndpoint", e.message.orEmpty())
            }
        }

        delete("{id?}") {
            val id = call.parameters["id"]?.toLong() ?: return@delete call.respond(
                HttpStatusCode.BadRequest
            )
            call.respondText(
                text = "Unsupported operation on Order with ID $id",
                status = HttpStatusCode.BadRequest
            )

        }
    }
}


