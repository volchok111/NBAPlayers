package com.volchok.nbaplayers.feature.details.di

import com.volchok.nbaplayers.feature.details.domain.GoBackUseCase
import com.volchok.nbaplayers.feature.details.domain.OpenTeamInfoUseCase
import com.volchok.nbaplayers.feature.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val detailsModule = module {
    viewModelOf(::DetailsViewModel)

    factoryOf(::GoBackUseCase)
    factoryOf(::OpenTeamInfoUseCase)
}