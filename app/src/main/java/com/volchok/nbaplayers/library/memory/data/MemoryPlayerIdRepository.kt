package com.volchok.nbaplayers.library.memory.data

import com.volchok.nbaplayers.library.memory.domain.PlayerIdRepository

class MemoryPlayerIdRepository: PlayerIdRepository {
    override var selectedPlayerId: Int = 0
}