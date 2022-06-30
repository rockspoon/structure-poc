package com.example.poc.datasource.remoteclientapi.user

import retrofit.Call
import retrofit.http.GET
import retrofit.http.Path

interface UserService {

    @GET("users/{user}")
    fun get(
        @Path("user") user: String?)
    : Call<UserResource>

}