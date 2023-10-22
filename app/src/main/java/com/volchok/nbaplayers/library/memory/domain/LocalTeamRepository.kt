package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import kotlinx.coroutines.flow.Flow

interface LocalTeamRepository {
    val team: Flow<TeamEntity>

    fun set(team: TeamEntity)
}