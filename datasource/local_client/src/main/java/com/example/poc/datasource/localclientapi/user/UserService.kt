package com.example.poc.datasource.localclientapi.user

import com.example.poc.datasource.localclientapi.user.UserResource
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Path

interface UserService {

    @GET("users/{user}")
    fun get(
        @Path("user") user: String?)
    : Call<UserResource>

}