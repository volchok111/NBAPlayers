package com.volchok.nbaplayers.library.paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.volchok.nbaplayers.library.api.data.NbaApi
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.paging.domain.PlayerRepository
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(
    private val nbaApi: NbaApi
) : PlayerRepository {
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
}