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
            MainEvent.OnMainStarted -> navigateToLaunchScreen()
            MainEvent.OnMainReady -> navigateToMainScreen()
        }
    }

    private fun navigateToLaunchScreen() {
        _mainDestinations.trySend(MainViewModel.Destination(resId = R.id.splashFragment))
    }

    private fun navigateToMainScreen(){
        _mainDestinations.trySend(MainViewModel.Destination(resId = R.id.mainFragment))
    }
}