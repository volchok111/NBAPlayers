package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.use_case.SynchronousUseCase
import kotlinx.coroutines.flow.Flow

class ObservePlayerDetailsUseCase(
    private val localPlayerRepository: LocalPlayerRepository
) : SynchronousUseCase<Unit, Flow<PlayerDetailsEntity>>{
    override fun invoke(input: Unit): Flow<PlayerDetailsEntity> = localPlayerRepository.player
}