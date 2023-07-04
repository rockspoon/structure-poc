package com.example.poc.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.core.domain.base.UseCase
import com.example.poc.core.ui.event.AppPocEvent
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureAuthEvent
import com.example.poc.core.ui.event.FeatureSearchEvent
import com.example.poc.core.ui.event.FeatureSettingsEvent
import com.example.poc.domain.CheckUserIsLoggedInUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * A view model shared between fragments and MainActivity used to coordinate
 * actions like navigation.
 */
internal class MainViewModel(
    private val featureAuthEventDelegate: FeatureAuthEventDelegate,
    private val appPocEventDelegate: AppPocEventDelegate,
    private val featureSearchEventDelegate: FeatureSearchEventDelegate,
    private val featureSettingsEventDelegate: FeatureSettingsEventDelegate,
    private val checkUserIsLoggedInUseCase: CheckUserIsLoggedInUseCase,
) : ViewModel(),
    AppPocEventDelegate by appPocEventDelegate,
    FeatureAuthEventDelegate by featureAuthEventDelegate,
    FeatureSearchEventDelegate by featureSearchEventDelegate,
    FeatureSettingsEventDelegate by featureSettingsEventDelegate {

    var isFastInitReady: Boolean = false

    // Snippet taken from IO scheduler app.
    private val _destinations = Channel<Destination>(capacity = Channel.CONFLATED)
    val destinations = _destinations.receiveAsFlow()

    /**
     * List of destination flows from delegates
     */
    private val destinationFlows = listOf(
        appPosDestinations,
        featureAuthDestinations,
        featureSearchDestinations,
        featureSettingsDestinations
    )

    init {
        destinationFlows.forEach { destinationFlow ->
            destinationFlow
                .onEach { _destinations.trySend(it) }
                .launchIn(viewModelScope)
        }
        slowInitializationTask()
    }

    private fun slowInitializationTask() {
        viewModelScope.launch {
            checkUserIsLoggedInUseCase(Unit).collect { result ->
                when (result) {
                    is UseCase.Result.Success -> {
                        if (result.data) {
                            onEvent(AppPocEvent.OnAppPocReady)
                        } else {
                            onEvent(AppPocEvent.OnAppPocAuthNeed)
                        }
                    }

                    is UseCase.Result.Loading -> onEvent(AppPocEvent.OnAppPocStarted)
                    else -> Unit
                }
            }
        }
    }

    /**
     * Distribute the event to the appropriate delegate.
     */
    fun onEvent(event: EventViewModel.Event) {
        when (event) {
            is AppPocEvent -> onAppPocEvent(event)
            is FeatureAuthEvent -> onFeatureAuthEvent(event)
            is FeatureSearchEvent -> onFeatureSearchEvent(event)
            is FeatureSettingsEvent -> onFeatureSettingsEvent(event)
        }
    }

    data class Destination(
        val resId: Int,
        val args: Bundle? = null
    ) {
        companion object {
            val POP_TO_START = Destination(resId = -2)
            val DESTINATION_UP = Destination(resId = -1)
        }
    }
}
