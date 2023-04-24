package com.example.poc.ui.main

import androidx.core.os.bundleOf
import com.example.poc.R
import com.example.poc.core.ui.event.FeatureAuthEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface FeatureAuthEventDelegate {

    val featureAuthDestinations: Flow<MainViewModel.Destination>

    fun onFeatureAuthEvent(event: FeatureAuthEvent)
}

internal class FeatureAuthEventDelegateImpl : FeatureAuthEventDelegate {

    private val _featureAuthDestinations = Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val featureAuthDestinations = _featureAuthDestinations.receiveAsFlow()

    override fun onFeatureAuthEvent(event: FeatureAuthEvent) {
        when (event) {
            is FeatureAuthEvent.OnAuthenticationCompleted -> onAuthSuccess(event.token)
            is FeatureAuthEvent.OnShitHappens -> onShitHappens(event)
        }
    }

    private fun onAuthSuccess(token: String) {
        _featureAuthDestinations.trySend(
            MainViewModel.Destination(
                resId = R.id.containerFragment,
                args = bundleOf("TOKEN" to token)
            )
        )
    }

    private fun onShitHappens(featureAuthEvent: FeatureAuthEvent) {
        // TODO Handle the shit here.
        // Common cases:
        // 1. If the activity UI changes when shit happens we need a shit UI state in our delegate.
        // 2. If data changes, we need a shit repository to put the shit together
        // 3. We can also navigate the user to a page so he can handle his own shit.
        // Most of the time though the fragment view model can handle the events by themselves.
        // Whenever possible handle the shit on the fragment level.
    }
}