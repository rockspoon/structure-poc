package com.example.poc.core.ui.event

sealed class AuthEvent : Event {
    data class OnAuthenticationCompleted(val token: String) : AuthEvent()
    data class OnShitHappens(val shitToBeDealtWith: String) : AuthEvent()
}