package com.volchok.nbaplayers.app.di

import com.volchok.nbaplayers.app.device.GlobalNavigationController
import com.volchok.nbaplayers.app.domain.MainNavigationController
import com.volchok.nbaplayers.app.domain.ObserveNavigationEventsUseCase
import com.volchok.nbaplayers.app.presentation.MainViewModel
import com.volchok.nbaplayers.feature.details.domain.DetailsNavigationController
import com.volchok.nbaplayers.feature.home.domain.HomeNavigationController
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.binds
import org.koin.dsl.module

internal val mainModule = module {
    viewModelOf(::MainViewModel)
    factory { ObserveNavigationEventsUseCase(get()) }

    single { GlobalNavigationController() }.binds(
        arrayOf(
            MainNavigationController::class,
            HomeNavigationController::class,
            DetailsNavigationController::class
        )
    )
}