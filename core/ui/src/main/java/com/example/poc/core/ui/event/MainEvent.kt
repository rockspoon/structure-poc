package com.example.poc.core.ui.event

sealed class MainEvent : Event {
    object OnMainStarted : MainEvent()
    object OnMainReady : MainEvent()
}