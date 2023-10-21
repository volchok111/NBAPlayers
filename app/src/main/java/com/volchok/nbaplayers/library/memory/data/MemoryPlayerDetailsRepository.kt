package com.volchok.nbaplayers.library.memory.data

import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.memory.domain.LocalPlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

class MemoryPlayerDetailsRepository : LocalPlayerRepository {
    private val _player = MutableStateFlow<PlayerDetailsEntity?>(value = null)
    override val player: Flow<PlayerDetailsEntity> = _player.filterNotNull()
    override fun set(player: PlayerDetailsEntity) {
        _player.tryEmit(player)
    }
}