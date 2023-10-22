package com.volchok.nbaplayers.feature.team.presentation

import androidx.lifecycle.viewModelScope
import com.volchok.nbaplayers.feature.details.domain.GoBackUseCase
import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import com.volchok.nbaplayers.library.memory.domain.FetchTeamUseCase
import com.volchok.nbaplayers.library.memory.domain.ObserveTeamUseCase
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.use_case.invoke
import kotlinx.coroutines.launch

class TeamViewModel(
    private val goBackUseCase: GoBackUseCase,
    private val fetchTeamUseCase: FetchTeamUseCase,
    private val observeTeamUseCase: ObserveTeamUseCase
): AbstractViewModel<TeamViewModel.State>(State()) {

    init {
        viewModelScope.launch {
            fetchTeamUseCase()
        }
        viewModelScope.launch {
            observeTeamUseCase().collect {
                state = state.copy(team = it, loading = false)
            }
        }
    }

    fun onBackClick() {
        goBackUseCase()
    }

    data class State(
        val loading: Boolean = true,
        val team: TeamEntity? = null
    ): AbstractViewModel.State
}