package com.example.poc.core.data.credentials

sealed class GetCredentialsRequest {
    data class Email(val email: String, val password: String) : GetCredentialsRequest()
    data class PinCode(val pinCode: String, val key: String, val deviceId: String) : GetCredentialsRequest()
}