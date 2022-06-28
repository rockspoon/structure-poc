package com.example.poc.server.service

import android.util.Log
import com.example.poc.server.data.Order
import com.example.poc.server.domain.GetOrderUseCase
import com.example.poc.server.domain.SendOrderToKitchenUseCase
import com.example.poc.server.domain.SendOrderToKitchenUseCase.NonOpenOrderSentToKitchenException
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
    private val sendOrderToKitchenUseCase: SendOrderToKitchenUseCase,
    private val orderStorage: HashMap<Long, Order> = hashMapOf()
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
            val order =
                this@OrderEndpoint.orderStorage[id] ?: return@get call.respondText(
                    text = "No order with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(order)
        }

        post {
            val order = call.receive<Order>()
            this@OrderEndpoint.orderStorage[order.id ?: 1] = order
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

                val order = this@OrderEndpoint.getOrderUseCase(orderId)

                val orderUpdated = when (body.status) {
                    Order.Status.OPEN -> {
                        TODO()
                        // Not sure if order can be update to open.
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
            if (this@OrderEndpoint.orderStorage.remove(id) != null) {
                call.respondText("Order removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}
//
//fun Route.orderEndpoint(
//    sendOrderToKitchenUseCase: SendOrderToKitchenUseCase = SendOrderToKitchenUseCase(object : OrderRepository{})
//) {
//
//    route("/order") {
//
//        get("{id?}") {
//            val id = call.parameters["id"]?.toLong() ?: return@get call.respondText(
//                text = "Missing id",
//                status = HttpStatusCode.BadRequest
//            )
//            val order =
//                orderStorage[id] ?: return@get call.respondText(
//                    text = "No order with id $id",
//                    status = HttpStatusCode.NotFound
//                )
//            call.respond(order)
//        }
//
//        post {
//            val order = call.receive<Order>()
//            orderStorage[order.id ?: 1] = order
//            call.respondText(
//                text = "Order stored correctly",
//                status = HttpStatusCode.Created
//            )
//        }
//
//        put {
//            val body = call.receive<Order>()
//
//            // Yeah, sue me
//            val order = orderStorage[body.id!!]!!
//
//            when (order.status){
//                Order.Status.OPEN -> {
//                    // If the order status was open and now is preparing, mean send to the kitchen
//                    if(body.status == Order.Status.PREPARING){
//                        order.status = Order.Status.PREPARING
//                        sendOrderToKitchenUseCase(order)
//                    }
//                }
//                Order.Status.PREPARING -> TODO()
//                Order.Status.READY -> TODO()
//                Order.Status.IN_TRANSIT -> TODO()
//                Order.Status.DELIVERED -> TODO()
//            }
//
//            orderStorage[order.id]
//            call.respondText(
//                text = "Order stored correctly",
//                status = HttpStatusCode.Created
//            )
//        }
//
//
//        delete("{id?}") {
//            val id = call.parameters["id"]?.toLong() ?: return@delete call.respond(
//                HttpStatusCode.BadRequest
//            )
//            if (orderStorage.remove(id) != null) {
//                call.respondText("Order removed correctly", status = HttpStatusCode.Accepted)
//            } else {
//                call.respondText("Not Found", status = HttpStatusCode.NotFound)
//            }
//        }
//    }
//}


