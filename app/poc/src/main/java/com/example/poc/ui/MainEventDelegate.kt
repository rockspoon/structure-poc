package com.example.poc.ui

import com.example.poc.R
import com.example.poc.core.ui.event.MainEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface MainEventDelegate {

    val mainDestinations: Flow<MainViewModel.Destination>

    fun onMainEvent(mainEvent: MainEvent)
}

internal class MainEventDelegateImpl : MainEventDelegate {

    private val _mainDestinations = Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val mainDestinations = _mainDestinations.receiveAsFlow()

    override fun onMainEvent(mainEvent: MainEvent) {
        when (mainEvent) {
            is MainEvent.OnMainStarted -> onMainStarted()
        }
    }

    private fun onMainStarted() {
        navigateToAuthOrMain()
    }

    // This is fake. We should store the authenticated user account in the Android
    // account manager and to check if the user is authenticated retrieve it, together
    // with the OAuth token.
    private var isUserAuthenticated = false

    private fun navigateToAuthOrMain() {
        // Main screen requires user to be authenticated.
        val destinationId = if (!isUserAuthenticated) R.id.featureAuthGraphId
        else R.id.mainFragment

        _mainDestinations.trySend(MainViewModel.Destination(resId = destinationId))
    }
}