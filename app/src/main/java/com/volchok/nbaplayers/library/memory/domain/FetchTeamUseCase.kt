package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.domain.RemoteRepository
import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.data.model.safeCall
import com.volchok.nbaplayers.library.use_case.SuspendUseCase
import com.volchok.nbaplayers.library.use_case.invoke

class FetchTeamUseCase(
    private val repository: RemoteRepository,
    private val localTeamRepository: LocalTeamRepository,
    private val getSelectedTeamIdUseCase: GetSelectedTeamIdUseCase
) : SuspendUseCase<Unit, Data<TeamEntity>>{
    override suspend fun invoke(input: Unit): Data<TeamEntity> = safeCall {
        teamInfo()
    }

    private suspend fun teamInfo(): TeamEntity {
        val teamId = getSelectedTeamIdUseCase()
        val result = repository.getTeamDetails(teamId).getSuccessValueOrThrow()
        val team = TeamEntity(
            abbreviation = result.abbreviation,
            city = result.city,
            conference = result.conference,
            division = result.division,
            full_name = result.full_name,
            id = result.id,
            name = result.name
        )
        localTeamRepository.set(team)
        return team
    }
}