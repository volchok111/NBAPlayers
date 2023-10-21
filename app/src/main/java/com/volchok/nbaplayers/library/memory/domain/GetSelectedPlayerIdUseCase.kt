package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class GetSelectedPlayerIdUseCase(
    private val repository: PlayerIdRepository
) : SynchronousUseCase<Unit, Int>{
    override fun invoke(input: Unit): Int  = repository.selectedPlayerId
}