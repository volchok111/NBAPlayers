package com.volchok.nbaplayers.app.domain

import com.volchok.nbaplayers.app.model.NavigationEvent
import kotlinx.coroutines.flow.Flow

interface MainNavigationController {
    val navigationEvent: Flow<NavigationEvent>

    fun goBack()

    fun goHome()

}