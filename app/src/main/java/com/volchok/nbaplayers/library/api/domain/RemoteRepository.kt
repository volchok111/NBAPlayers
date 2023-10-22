package com.volchok.nbaplayers.library.api.domain

import androidx.paging.PagingData
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.api.model.team.TeamEntity
import com.volchok.nbaplayers.library.data.model.Data
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    fun getPlayers(): Data<Flow<PagingData<PlayerModel>>>

   suspend fun getPlayerDetails(id: Int): Data<PlayerDetailsEntity>

    suspend fun getTeamDetails(id: Int): Data<TeamEntity>
}