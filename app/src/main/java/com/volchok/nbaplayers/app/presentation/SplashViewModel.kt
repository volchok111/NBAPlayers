package com.volchok.nbaplayers.app.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.nbaplayers.app.domain.GoToHomeUseCase
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.use_case.invoke
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    private val goToHomeUseCase: GoToHomeUseCase
): AbstractViewModel<SplashViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            delay(1500)
            state = state.copy(loading = false)
            goToHomeUseCase()
        }
    }

    data class State(
        val test: String = "",
        val loading: Boolean = true
    ): AbstractViewModel.State
}