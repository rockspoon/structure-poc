package com.example.poc.ui.main

import com.example.poc.core.ui.event.FeatureSettingsEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface FeatureSettingsEventDelegate {

    val featureSettingsDestinations: Flow<MainViewModel.Destination>

    fun onFeatureSettingsEvent(event: FeatureSettingsEvent)
}

internal class FeatureSettingsEventDelegateImpl : FeatureSettingsEventDelegate {

    private val _featureSettingsDestinations =
        Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val featureSettingsDestinations = _featureSettingsDestinations.receiveAsFlow()

    override fun onFeatureSettingsEvent(event: FeatureSettingsEvent) {
        when (event) {
            is FeatureSettingsEvent.OnPermissionRequired -> requestPermission()
        }
    }

    private fun requestPermission() {
        // TODO
    }
}