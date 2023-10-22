package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class GetSelectedTeamIdUseCase(
    private val repository: TeamIdRepository
) : SynchronousUseCase<Unit, Int>{
    override fun invoke(input: Unit): Int = repository.selectedTeamId
}