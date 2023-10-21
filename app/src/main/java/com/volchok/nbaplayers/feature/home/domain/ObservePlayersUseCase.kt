package com.volchok.nbaplayers.feature.home.domain

import androidx.paging.PagingData
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.paging.domain.PlayerRepository
import com.volchok.nbaplayers.library.use_case.SuspendUseCase
import kotlinx.coroutines.flow.Flow

class ObservePlayersUseCase(
    private val playerRepository: PlayerRepository
) : SuspendUseCase<Unit, Data<Flow<PagingData<PlayerModel>>>>{
    override suspend fun invoke(input: Unit): Data<Flow<PagingData<PlayerModel>>> {
        return playerRepository.getPlayers()
    }
}