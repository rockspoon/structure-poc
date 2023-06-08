package com.example.poc.core.data.credentials

interface CredentialsRemoteDataSource {

    /**
     * Retrieves an user from the RockSpoon merchant web service
     */
    suspend fun getCredentials(email: String, password: String): Credentials?

    /**
     * Uses the refresh token to get new credentials tokens
     */
    suspend fun updateCredentials(refreshToken: String): Credentials

    object InvalidRefreshTokenException : RuntimeException("Invalid refresh token.")

    object InvalidEmailOrPasswordException : RuntimeException("Invalid email or password.")

}