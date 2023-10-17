package com.volchok.nbaplayers.app.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase
import com.volchok.nbaplayers.app.model.NavigationEvent
import kotlinx.coroutines.flow.Flow

class ObserveNavigationEventsUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Flow<NavigationEvent>> {

    override fun invoke(input: Unit): Flow<NavigationEvent> =
        mainNavigationController.navigationEvent
}