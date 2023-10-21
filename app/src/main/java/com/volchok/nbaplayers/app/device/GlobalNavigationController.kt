package com.volchok.nbaplayers.app.device

import com.volchok.nbaplayers.app.domain.MainNavigationController
import com.volchok.nbaplayers.app.model.BackNavigationEvent
import com.volchok.nbaplayers.app.model.ForwardNavigationEvent
import com.volchok.nbaplayers.app.model.NavigationEvent
import com.volchok.nbaplayers.app.model.Route
import com.volchok.nbaplayers.feature.home.domain.HomeNavigationController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class GlobalNavigationController :
    MainNavigationController,
    HomeNavigationController {

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    override val navigationEvent = _navigationEvent.asSharedFlow()

    override fun goBack() = goTo(BackNavigationEvent)

    override fun goToPlayerInfo() = goTo(ForwardNavigationEvent(Route.Details))

    private fun goTo(navigationEvent: NavigationEvent) {
        _navigationEvent.tryEmit(navigationEvent)
    }
}