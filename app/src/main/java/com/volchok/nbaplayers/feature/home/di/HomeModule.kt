package com.volchok.nbaplayers.feature.home.di

import com.volchok.nbaplayers.feature.home.domain.OpenPlayerInfoUseCase
import com.volchok.nbaplayers.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
    factoryOf(::OpenPlayerInfoUseCase)
}