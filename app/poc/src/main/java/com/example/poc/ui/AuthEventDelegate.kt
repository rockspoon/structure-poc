package com.example.poc.ui

import androidx.core.os.bundleOf
import com.example.poc.R
import com.example.poc.core.ui.event.AuthEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

internal interface AuthEventDelegate {

    val authDestinations: Flow<MainViewModel.Destination>

    fun onAuthEvent(event: AuthEvent)
}

internal class AuthEventDelegateImpl : AuthEventDelegate {

    private val _authDestinations = Channel<MainViewModel.Destination>(capacity = Channel.CONFLATED)
    override val authDestinations = _authDestinations.receiveAsFlow()

    override fun onAuthEvent(authEvent: AuthEvent) {
        when (authEvent) {
            is AuthEvent.OnAuthenticationCompleted -> onAuthSuccess(authEvent.token)
            is AuthEvent.OnShitHappens -> onShitHappens(authEvent)
        }
    }

    private fun onAuthSuccess(token: String) {
        _authDestinations.trySend(
            MainViewModel.Destination(
                resId = R.id.mainFragment,
                args = bundleOf("TOKEN" to token)
            )
        )
    }

    private fun onShitHappens(authEvent: AuthEvent) {
        // TODO Handle the shit here.
        // Common cases:
        // 1. If the activity UI changes when shit happens we need a shit UI state in our delegate.
        // 2. If data changes, we need a shit repository to put the shit together
        // 3. We can also navigate the user to a page so he can handle his own shit.
        // Most of the time though the fragment view model can handle the events by themselves.
        // Whenever possible handle the shit on the fragment level.
    }
}