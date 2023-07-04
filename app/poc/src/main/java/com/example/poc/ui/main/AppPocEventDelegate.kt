package com.example.poc.ui.main

import com.example.poc.R
import com.example.poc.core.ui.event.AppPocEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface AppPocEventDelegate {

    val appPosDestinations: Flow<MainViewModel.Destination>

    fun onAppPocEvent(event: AppPocEvent)
}

internal class AppPocEventDelegateImpl : AppPocEventDelegate {

    private val _appPosDestinations = Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val appPosDestinations = _appPosDestinations.receiveAsFlow()

    override fun onAppPocEvent(event: AppPocEvent) {
        when (event) {
            AppPocEvent.OnAppPocStarted -> navigateToLoadingScreen()
            AppPocEvent.OnAppPocReady -> navigateToContainerScreen()
        }
    }

    private fun navigateToLoadingScreen() {
        _appPosDestinations.trySend(MainViewModel.Destination(resId = R.id.loadingFragment))
    }

    private fun navigateToContainerScreen(){
        _appPosDestinations.trySend(MainViewModel.Destination(resId = R.id.containerFragment))
    }
}