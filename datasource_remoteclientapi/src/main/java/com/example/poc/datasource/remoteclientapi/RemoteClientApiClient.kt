package com.example.poc.datasource.remoteclientapi

import com.example.poc.datasource.remoteclientapi.order.OrderService
import com.example.poc.datasource.remoteclientapi.user.UserService
import retrofit.Retrofit

class RemoteClientApiClient(
    retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()
) {

    var order: OrderService = retrofit.create(OrderService::class.java)

    var user: UserService = retrofit.create(UserService::class.java)
}