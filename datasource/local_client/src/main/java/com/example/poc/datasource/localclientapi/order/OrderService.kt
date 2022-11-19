package com.example.poc.datasource.localclientapi.order

import retrofit.Call
import retrofit.http.Body
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.Path

interface OrderService {

    @GET("order/{id}")
    fun get(
        @Path("order") id: Long?
    ): Call<OrderResource>

    @POST("order")
    fun insert(
        @Body entity: OrderResource?
    ): Call<OrderResource>

}