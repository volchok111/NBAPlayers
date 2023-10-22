package com.volchok.nbaplayers.app.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.nbaplayers.app.domain.ObserveNavigationEventsUseCase
import com.volchok.nbaplayers.app.model.ForwardNavigationEvent
import com.volchok.nbaplayers.app.model.NavigationEvent
import com.volchok.nbaplayers.app.model.Route
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.networking.domain.ObserveConnectionUseCase
import com.volchok.nbaplayers.library.networking.model.NetworkConnection
import kotlinx.coroutines.launch

class MainViewModel(
    private val observeNavigationEventsUseCase: ObserveNavigationEventsUseCase,
    private val observeConnectionUseCase: ObserveConnectionUseCase
) : AbstractViewModel<MainViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observeNavigationEventsUseCase(Unit).collect { onNavigationEvent(it) }
        }

        viewModelScope.launch {
            observeConnectionUseCase(Unit).collect { onConnectionChanged(it) }
        }
    }

    private fun onNavigationEvent(navigationEvent: NavigationEvent) {
        state = state.copy(navigationEvent = navigationEvent)
    }

    fun onNavigationEventConsumed() {
        state = state.copy(navigationEvent = null)
    }

    private fun onConnectionChanged(connection: NetworkConnection) {
        state = state.copy(isOffline = connection == NetworkConnection.Offline)
    }

    data class State(
        val navigationEvent: NavigationEvent? = ForwardNavigationEvent(Route.Initial),
        val isOffline: Boolean = false
    ) : AbstractViewModel.State
}