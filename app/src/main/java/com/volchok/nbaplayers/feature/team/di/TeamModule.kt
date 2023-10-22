package com.volchok.nbaplayers.feature.team.di

import com.volchok.nbaplayers.feature.team.presentation.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val teamModule = module {
    viewModelOf(::TeamViewModel)
}