package com.volchok.nbaplayers.feature.home.presentation

import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel

class HomeViewModel(
) : AbstractViewModel<HomeViewModel.State>(State()) {


    data class State(
        val loading: Boolean = true,
    ) : AbstractViewModel.State
}