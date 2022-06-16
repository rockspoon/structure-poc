package com.example.poc.server.service

import com.example.poc.server.data.OrderEntity
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * An endpoint for Orders resources
 */
fun Route.orderEndpoint() {

    val orderStorage = mutableListOf<OrderEntity>()

    route("/order") {

        get("{id?}") {
            val id = call.parameters["id"]?.toLong() ?: return@get call.respondText(
                text = "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val order =
                orderStorage.find { it.id == id } ?: return@get call.respondText(
                    text = "No order with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(order)
        }

        post {
            val order = call.receive<OrderEntity>()
            orderStorage.add(order)
            call.respondText(
                text = "Order stored correctly",
                status = HttpStatusCode.Created
            )
        }

        delete("{id?}") {
            val id = call.parameters["id"]?.toLong() ?: return@delete call.respond(
                HttpStatusCode.BadRequest
            )
            if (orderStorage.removeIf { it.id == id }) {
                call.respondText("Order removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}