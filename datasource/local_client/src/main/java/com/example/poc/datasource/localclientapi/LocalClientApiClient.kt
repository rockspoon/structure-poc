package com.example.poc.datasource.localclientapi

import com.example.poc.datasource.localclientapi.order.OrderService
import com.example.poc.datasource.localclientapi.user.UserService
import retrofit.Retrofit

class LocalClientApiClient(
    retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()
) {

    var order: OrderService = retrofit.create(OrderService::class.java)

    var user: UserService = retrofit.create(UserService::class.java)
}