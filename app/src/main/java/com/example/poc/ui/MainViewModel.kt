package com.example.poc.ui

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.example.poc.R
import com.example.poc.core.data.order.Order
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/**
 * A view model shared between fragments and MainActivity used to coordinate
 * actions like navigation.
 */
class MainViewModel : ViewModel() {

    // TODO This is fake. We should store the authenticated user account in the Android
    //      account manager and to check if the user is authenticated retrieve it, together
    //      with the OAuth token.
    var isUserAuthenticated = false

    // Snippet took from IO scheduler app.
    // SIDE EFFECTS: Navigation actions
    // Exposed with receiveAsFlow to make sure that only one observer receives updates.
    private val _destinations = Channel<Destination>(capacity = Channel.CONFLATED)
    val destinations = _destinations.receiveAsFlow()

    private val _actions = Channel<Action>(capacity = Channel.CONFLATED)
    val actions = _actions.receiveAsFlow()

    /**
     * Navigate to home screen.
     */
    fun startMain() {

        // Main screen requires user to be authenticated.
        if (!isUserAuthenticated) {

            // Start the auth flow and observe when it is completed
            // TODO what if two makes an authentication request. Eventually the two destinations
            // would be called?
            startAuth().onEach {
                _destinations.trySend(Destination(resId = R.id.mainFragment))
            }.launchIn(viewModelScope)

            return
        }

        _destinations.trySend(
            Destination(resId = R.id.mainFragment)
        )
    }

    // TODO This will not scale well. When we have thousands of features we will end up with
    //      2 thousands of methods in this view model. Instead, we should make the feature send the
    //      action instead.
    /**
     * Navigate to auth flow and return a Flow to observe when the process is completed.
     * It's
     */
    // I need somehow pass here a follow up, like a callback
    private fun startAuth(): Flow<Action> {
        _destinations.trySend(Destination(resId = R.id.featureAuthGraphId))
        return actions.filter { it is Action.AuthenticationCompleted }
    }

    // TODO This will scale better. When we have thousands of features, we will have thousands of
    //      actions but not thousands of methods, but we will need a thousand of flows returning
    /**
     * Universal listener for completion actions from features.
     */
    fun onAction(action: Action) {
        // Notify the ones interested.
        _actions.trySend(action)
    }

    data class Destination(
        @IdRes val resId: Int,
        val args: Bundle? = null,
        val navOptions: NavOptions? = null,
        val navigatorExtras: Navigator.Extras? = null
    )

    // Action, or Event, or Result?
    sealed class Action {
        object AuthenticationCompleted : Action()
        data class NavigationItemSelected(@IdRes val itemId: Int) : Action()
        // This cannot be separated by feature since two features may result in the same action,
        // like home and search may send an OrderSelected action
        data class OrderSelected(val order: Order) : Action()
    }

}