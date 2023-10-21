package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.domain.RemoteRepository
import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.data.model.safeCall
import com.volchok.nbaplayers.library.use_case.SuspendUseCase
import com.volchok.nbaplayers.library.use_case.invoke

class FetchPlayerDetailsUseCase(
    private val repository: RemoteRepository,
    private val localPlayerRepository: LocalPlayerRepository,
    private val getSelectedPlayerIdUseCase: GetSelectedPlayerIdUseCase,
) : SuspendUseCase<Unit, Data<PlayerDetailsEntity>> {
    override suspend fun invoke(input: Unit): Data<PlayerDetailsEntity> = safeCall {
        playerInfo()
    }

    private suspend fun playerInfo(): PlayerDetailsEntity {
        val playerId = getSelectedPlayerIdUseCase()
        val result = repository.getPlayerDetails(playerId).getSuccessValueOrThrow()
        val player = PlayerDetailsEntity(
            first_name = result.first_name,
            height_feet = result.height_feet,
            height_inches = result.height_inches,
            id = result.id,
            last_name = result.last_name,
            position = result.position,
            team = result.team,
            weight_pounds = result.weight_pounds
        )
        localPlayerRepository.set(player)
        return player
    }
}