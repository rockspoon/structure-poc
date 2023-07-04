package com.example.poc.core.ui.event

sealed class AppPocEvent : EventViewModel.Event {
    object OnAppPocStarted : AppPocEvent()
    object OnAppPocReady : AppPocEvent()
}