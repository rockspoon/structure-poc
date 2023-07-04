package com.example.poc.core.ui.event

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/**
 * A view model shared between fragments and MainActivity used to coordinate
 * actions like navigation.
 */
// NOTE I either create a view model for each feature or let exposed the events for every
// feature.
class EventViewModel : ViewModel() {

    private val _events = Channel<Event>(capacity = Channel.CONFLATED)

    /**
     * This should be used exclusively by MainActivity. Fragments should not handle these events.
     */
    val events = _events.receiveAsFlow()

    fun postEvent(event: Event) {
        _events.trySend(event)
    }

    /**
     * Represents an UI event. This should be used only for events that need to be handled by the
     * activity.
     */
    interface Event
}