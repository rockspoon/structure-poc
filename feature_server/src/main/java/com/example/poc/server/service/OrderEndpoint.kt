package com.example.poc.server.service

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository
import com.example.poc.server.domain.SendOrderToKitchenUseCase
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*



/**
 * An endpoint for Orders resources
 */
// TODO figure out how dependency injection will work here so we have a repository for orders and
//      save it
class OrderEndpoint(
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


