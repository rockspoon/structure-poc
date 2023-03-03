package com.example.poc.ui

import com.example.poc.core.ui.event.SettingsEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface SettingsEventDelegate {

    val settingsDestinations: Flow<MainViewModel.Destination>

    fun onSettingsEvent(event: SettingsEvent)
}

internal class SettingsEventDelegateImpl : SettingsEventDelegate {

    private val _settingsDestinations =
        Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val settingsDestinations = _settingsDestinations.receiveAsFlow()

    override fun onSettingsEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.OnPermissionRequested -> onPermissionRequested()
        }
    }

    private fun onPermissionRequested() {
        // TODO
    }
}