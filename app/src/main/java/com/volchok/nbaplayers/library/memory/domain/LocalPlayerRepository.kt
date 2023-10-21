package com.volchok.nbaplayers.library.memory.domain

import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import kotlinx.coroutines.flow.Flow

interface LocalPlayerRepository {
    val player: Flow<PlayerDetailsEntity>

    fun set(player: PlayerDetailsEntity)
}