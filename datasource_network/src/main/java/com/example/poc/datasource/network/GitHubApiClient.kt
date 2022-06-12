package com.example.poc.datasource.network

import com.example.poc.datasource.network.user.UserService
import retrofit.Retrofit

class GitHubApiClient(
    retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()
) {
    var user: UserService = retrofit.create(UserService::class.java)
}