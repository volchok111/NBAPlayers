package com.volchok.nbaplayers.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.nbaplayers.library.api.domain.ObservePlayersUseCase
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.use_case.invoke
import kotlinx.coroutines.launch

class HomeViewModel(
    private val observePlayersUseCase: ObservePlayersUseCase
) : AbstractViewModel<HomeViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            observePlayersUseCase().collect { list ->
                if (list is Data.Success) {
                    state = state.copy(players = list.value.map { it.toItem() })
                }
            }
        }
    }

    private fun PlayerModel.toItem() = State.PlayerItem(
        id,
        first_name,
        last_name,
        team.full_name
    )

    data class State(
        val loading: Boolean = true,
        val players: List<PlayerItem> = emptyList()
    ) : AbstractViewModel.State {
        data class PlayerItem(
            val id: Int? = null,
            val first_name: String? = null,
            val last_name: String? = null,
            val teamName: String? = null
        )
    }
}