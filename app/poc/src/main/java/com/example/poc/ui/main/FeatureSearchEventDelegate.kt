package com.example.poc.ui.main

import com.example.poc.core.ui.event.FeatureSearchEvent
import com.example.poc.settings.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface FeatureSearchEventDelegate {

    val featureSearchDestinations: Flow<MainViewModel.Destination>

    fun onFeatureSearchEvent(event: FeatureSearchEvent)
}

internal class FeatureSearchEventDelegateImpl : FeatureSearchEventDelegate {

    private val _featureSearchDestinations =
        Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val featureSearchDestinations = _featureSearchDestinations.receiveAsFlow()

    override fun onFeatureSearchEvent(event: FeatureSearchEvent) {
        when (event) {
            is FeatureSearchEvent.OnActionSettingsClicked -> navigateToSettings()
        }
    }

    private fun navigateToSettings() {
        _featureSearchDestinations.trySend(
            MainViewModel.Destination(
                resId = R.id.featureSettingsGraphId
            )
        )
    }
}