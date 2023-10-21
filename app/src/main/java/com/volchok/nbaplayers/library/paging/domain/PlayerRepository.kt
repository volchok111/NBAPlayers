package com.volchok.nbaplayers.library.paging.domain

import androidx.paging.PagingData
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getPlayers(): Data<Flow<PagingData<PlayerModel>>>
}