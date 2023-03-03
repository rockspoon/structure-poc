package com.example.poc.core.ui.event

sealed class SettingsEvent : Event {
    object OnPermissionRequested : SettingsEvent()
}