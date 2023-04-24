package com.example.poc.core.ui.event

sealed class FeatureSearchEvent : EventViewModel.Event {
    object OnActionSettingsClicked : FeatureSearchEvent()
}