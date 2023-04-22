package com.example.poc.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.poc.core.ui.event.AuthEvent
import com.example.poc.core.ui.event.Event
import com.example.poc.core.ui.event.MainEvent
import com.example.poc.core.ui.event.SettingsEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * A view model shared between fragments and MainActivity used to coordinate
 * actions like navigation.
 */
internal class MainViewModel(
    private val authEventDelegate: AuthEventDelegate,
    private val mainEventDelegate: MainEventDelegate,
    private val settingsEventDelegate: SettingsEventDelegate
) : ViewModel(),
    AuthEventDelegate by authEventDelegate,
    MainEventDelegate by mainEventDelegate,
    SettingsEventDelegate by settingsEventDelegate {

    var isFastInitReady: Boolean = false

    // Snippet taken from IO scheduler app.
    private val _destinations = Channel<Destination>(capacity = Channel.CONFLATED)
    val destinations = _destinations.receiveAsFlow()

    init {
        authDestinations
            .onEach { _destinations.trySend(it) }
            .launchIn(viewModelScope)
        mainDestinations
            .onEach { _destinations.trySend(it) }
            .launchIn(viewModelScope)
        settingsDestinations
            .onEach { _destinations.trySend(it) }
            .launchIn(viewModelScope)
        fastInitializationTask()
        slowInitializationTask()
    }

    private fun fastInitializationTask(){
        viewModelScope.launch {
            delay(3_000)
            isFastInitReady = true
        }
    }

    private fun slowInitializationTask(){
        viewModelScope.launch {
            delay(6_000)
            onEvent(MainEvent.OnMainReady)
        }
    }

    fun onEvent(event: Event) {
        when (event) {
            is AuthEvent -> onAuthEvent(event)
            is MainEvent -> onMainEvent(event)
            is SettingsEvent -> onSettingsEvent(event)
        }
    }

    data class Destination(
        @IdRes val resId: Int,
        val args: Bundle? = null,
        val navOptions: NavOptions? = null,
        val navigatorExtras: Navigator.Extras? = null
    )
}
