package com.volchok.nbaplayers.feature.details.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.nbaplayers.feature.details.domain.GoBackUseCase
import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.memory.domain.FetchPlayerDetailsUseCase
import com.volchok.nbaplayers.library.memory.domain.ObservePlayerDetailsUseCase
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.use_case.invoke
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val fetchPlayerDetailsUseCase: FetchPlayerDetailsUseCase,
    private val observePlayerDetailsUseCase: ObservePlayerDetailsUseCase,
    private val goBackUseCase: GoBackUseCase
) : AbstractViewModel<DetailsViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            fetchPlayerDetailsUseCase()
        }
        viewModelScope.launch {
            observePlayerDetailsUseCase().collect {
                state = state.copy(player = it, loading = false)
            }
        }
    }

    fun onBackClick() {
        goBackUseCase()
    }

    data class State(
        val loading: Boolean = true,
        val player: PlayerDetailsEntity? = null
    ) : AbstractViewModel.State
}