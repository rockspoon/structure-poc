package com.example.poc.core.ui.event

sealed class FeatureSettingsEvent : EventViewModel.Event {
    object OnPermissionRequired : FeatureSettingsEvent()
}