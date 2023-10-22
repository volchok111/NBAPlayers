package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import com.volchok.nbaplayers.library.use_case.SynchronousUseCase
import kotlinx.coroutines.flow.Flow

class ObserveTeamUseCase(
    private val localTeamRepository: LocalTeamRepository
) : SynchronousUseCase<Unit, Flow<TeamEntity>>{
    override fun invoke(input: Unit): Flow<TeamEntity> = localTeamRepository.team
}