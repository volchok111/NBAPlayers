package com.volchok.nbaplayers.library.api.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.volchok.nbaplayers.library.api.domain.RemoteRepository
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import com.volchok.nbaplayers.library.data.model.Data
import kotlinx.coroutines.flow.Flow

class PlayerRepository(
    private val nbaApi: NbaApi
) : RemoteRepository {
    override fun getPlayers(): Data<Flow<PagingData<PlayerModel>>> {
        return try {
            val result = Pager(
                config = PagingConfig(pageSize = 35),
                pagingSourceFactory = { PlayerPagingSource(nbaApi) }
            ).flow
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(ex)
        }
    }

    override suspend fun getPlayerDetails(id: Int): Data<PlayerDetailsEntity> {
        return try {
            val result = nbaApi.getPlayerDetails(id)
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(cause = ex)
        }
    }
}