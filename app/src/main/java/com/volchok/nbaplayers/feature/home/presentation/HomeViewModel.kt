package com.volchok.nbaplayers.feature.home.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.volchok.nbaplayers.feature.home.domain.OpenPlayerInfoUseCase
import com.volchok.nbaplayers.library.api.domain.ObservePlayersUseCase
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.mvvm.presentation.AbstractViewModel
import com.volchok.nbaplayers.library.use_case.invoke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class HomeViewModel(
    private val observePlayersUseCase: ObservePlayersUseCase,
    private val openPlayerInfoUseCase: OpenPlayerInfoUseCase
) : AbstractViewModel<HomeViewModel.State>(State()) {

    private val _playerState: MutableStateFlow<PagingData<PlayerModel>> =
        MutableStateFlow(value = PagingData.empty())
    val playerState: MutableStateFlow<PagingData<PlayerModel>> get() = _playerState

    init {
        viewModelScope.launch {
            val result = observePlayersUseCase()
            if (result is Data.Success) {
                result.value
                    .distinctUntilChanged()
                    .cachedIn(viewModelScope)
                    .collect { players ->
                        _playerState.value = players
                    }
            }
        }
    }

    fun onItem(id: Int) {
        openPlayerInfoUseCase.invoke(id)
    }

    data class State(
        val loading: Boolean = true,
    ) : AbstractViewModel.State
}