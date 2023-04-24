package com.example.poc.core.ui.event

sealed class FeatureAuthEvent : EventViewModel.Event {
    data class OnAuthenticationCompleted(val token: String) : FeatureAuthEvent()
    data class OnShitHappens(val shitToBeDealtWith: String) : FeatureAuthEvent()
}