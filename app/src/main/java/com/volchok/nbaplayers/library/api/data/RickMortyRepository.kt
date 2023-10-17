package com.volchok.nbaplayers.library.api.data

import com.volchok.nbaplayers.library.api.domain.RemoteRepository
import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data

class RickMortyRepository(
    private val nbaApi: NbaApi
) : RemoteRepository {
    override suspend fun getCharacters(): Data<List<PlayerModel>> {
        return try {
            val result = nbaApi.getPlayers()
            Data.Success(result)
        } catch (ex: Exception) {
            Data.Error(cause = ex)
        }
    }
}