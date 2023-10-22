package com.volchok.nbaplayers.library.memory.data

import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import com.volchok.nbaplayers.library.memory.domain.LocalTeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

class MemoryTeamRepository : LocalTeamRepository {
    private val _team = MutableStateFlow<TeamEntity?>(value = null)
    override val team: Flow<TeamEntity> = _team.filterNotNull()
    override fun set(team: TeamEntity) {
        _team.tryEmit(team)
    }
}