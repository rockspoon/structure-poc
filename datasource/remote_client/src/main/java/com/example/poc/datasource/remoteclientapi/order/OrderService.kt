package com.example.poc.datasource.remoteclientapi.order

import retrofit.http.Body
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.Path

interface OrderService {

    @GET("order/{id}")
    suspend fun get(
            @Path("id") id: Long?
    ): OrderResource

    @POST("order")
    suspend fun insert(
            @Body entity: OrderResource?
    ): OrderResource

}