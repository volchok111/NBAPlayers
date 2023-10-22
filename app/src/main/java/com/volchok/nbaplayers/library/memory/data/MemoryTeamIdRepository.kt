package com.volchok.nbaplayers.library.memory.data

import com.volchok.nbaplayers.library.memory.domain.TeamIdRepository

class MemoryTeamIdRepository: TeamIdRepository {
    override var selectedTeamId: Int = 0

}